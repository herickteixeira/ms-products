package com.products.core.queries;

import an.awesome.pipelinr.Command;
import com.products.application.queries.GetProductsQuery;
import com.products.application.shared.Pagination;
import com.products.application.shared.PaginationResponse;
import com.products.core.domain.aggregates.product.ProductRepository;
import com.products.core.domain.aggregates.product.ProductResponse;
import com.products.core.domain.aggregates.product.ProductResponseMapper;
import com.products.core.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Component;

@Component
public class GetProductsQueryHandler implements Command.Handler<GetProductsQuery, PaginationResponse<ProductResponse>> {

    private final ProductRepository productRepository;

    public GetProductsQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public PaginationResponse<ProductResponse> handle(GetProductsQuery query) {

        var page = productRepository.findAll(Pagination.create(query.getPagination().getOffset(),
                query.getPagination().getLimit()));

        if (page.isEmpty()) throw new NotFoundException("Products is null");

        return new PaginationResponse<>(page.getOffset(), page.getLimit(),
                ProductResponseMapper.map(page.getElements()));
    }
}
