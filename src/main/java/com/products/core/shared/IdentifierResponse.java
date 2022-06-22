package com.products.core.shared;

import java.util.UUID;

public class IdentifierResponse {

    private final UUID id;

    public IdentifierResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}