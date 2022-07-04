package com.products.api.rest.controller;

import com.products.core.domain.aggregates.product.ProductRequest;
import com.products.core.domain.aggregates.product.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

public interface ProductController {

    @PostMapping("/save/product")
    ResponseEntity<Void> save(@RequestBody ProductRequest request, UriComponentsBuilder uriComponentsBuilder);


    @GetMapping("/products")
    ResponseEntity<List<ProductResponse>> getProducts(
            @RequestParam(required = false, defaultValue = "0") String offset,
            @RequestParam(required = false) String limit);
}
