package com.products.core.shared.validators;

public class StringValidator {

    private StringValidator() {
        throw new IllegalStateException("String Validator");
    }

    public static boolean isNullOrEmpty(String value) {
        return !((value != null) && (value.trim().length() > 0));
    }

    public static void isNullOrEmptyAndThrow(String value, String errorMessage) {
        CustomValidator.validateAndThrow(isNullOrEmpty(value), errorMessage);
    }
}
