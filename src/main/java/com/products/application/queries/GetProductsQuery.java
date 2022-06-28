package com.products.application.queries;

import an.awesome.pipelinr.Command;
import com.products.application.shared.PaginationRequest;
import com.products.application.shared.PaginationResponse;
import com.products.core.domain.aggregates.product.ProductResponse;

public class GetProductsQuery implements Command<PaginationResponse<ProductResponse>> {

    private final PaginationRequest pagination;

    public GetProductsQuery(PaginationRequest pagination) {
        this.pagination = pagination;
    }

    public PaginationRequest getPagination() {
        return pagination;
    }
}
