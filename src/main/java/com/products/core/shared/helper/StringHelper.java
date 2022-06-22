package com.products.core.shared.helper;

public class StringHelper {

    private StringHelper() {
        throw new IllegalStateException("String Helper");
    }

    public static String clean(String value) {
        return (value == null) ? null : value.trim();
    }
}
