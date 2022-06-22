package com.products.api.rest.controller;

import an.awesome.pipelinr.Pipeline;
import com.products.application.commands.ProductRequest;
import com.products.application.commands.SaveProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
public class ProductControllerImpl implements ProductController{

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
}
