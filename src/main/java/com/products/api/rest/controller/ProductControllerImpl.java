package com.products.api.rest.controller;

import an.awesome.pipelinr.Pipeline;
import com.products.application.commands.SaveProductCommand;
import com.products.application.queries.GetProductsQuery;
import com.products.application.shared.PaginationRequest;
import com.products.core.domain.aggregates.product.ProductRequest;
import com.products.core.domain.aggregates.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {

    private final Pipeline pipeline;

    public ProductControllerImpl(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @Override
    public ResponseEntity<Void> save(ProductRequest request, UriComponentsBuilder uriComponentsBuilder) {
        var response = pipeline.send(new SaveProductCommand(request));
        URI uri = uriComponentsBuilder.path("/products/{id}").buildAndExpand(response.getId().toString()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getProducts(String offset, String limit) {
        var pagination = new PaginationRequest(offset, limit);
        var response = pipeline.send(new GetProductsQuery(pagination));


        return ResponseEntity.ok().body(response.getElements());
    }
}
