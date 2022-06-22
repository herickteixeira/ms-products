package com.products.application.commands;

import an.awesome.pipelinr.Command;
import com.products.core.shared.IdentifierResponse;

import javax.validation.constraints.NotNull;

public class SaveProductCommand implements Command<IdentifierResponse> {

    @NotNull(message = "The product is null")
    private final ProductRequest request;
    private String message;

    public SaveProductCommand(ProductRequest request) {
        this.request = request;
    }

    public SaveProductCommand(ProductRequest request, String message) {
        this.request = request;
        this.message = message;
    }

    public ProductRequest getRequest() {
        return request;
    }

    public String getMessage() {
        return message;
    }
}