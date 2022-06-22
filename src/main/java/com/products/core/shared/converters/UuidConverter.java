package com.products.core.shared.converters;

import com.products.core.shared.exceptions.DomainException;

import java.util.UUID;

public class UuidConverter {
    private UuidConverter() {
        throw new IllegalStateException("Uuid Converter");
    }

    public static UUID fromString(String id) {
        try {
            return UUID.fromString(id);
        } catch (Exception var2) {
            throw new DomainException(String.format("Invalid id: %s", id));
        }
    }
}
