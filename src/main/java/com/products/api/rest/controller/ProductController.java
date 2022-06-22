package com.products.api.rest.controller;

import com.products.application.commands.ProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public interface ProductController {

    @PostMapping("/save/product")
    ResponseEntity<Void> save(@RequestBody ProductRequest request, UriComponentsBuilder uriComponentsBuilder);
}
