package com.products.core.shared.validators;

import com.products.core.shared.exceptions.NotFoundException;

import java.util.Optional;

public class ObjectValidator {
    private ObjectValidator() {
        throw new IllegalStateException("Object Validator");
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static void isNullAndThrow(Object obj, String errorMessage) {
        CustomValidator.validateAndThrow(isNull(obj), errorMessage);
    }

    public static <T> void isNullAndNotFoundThrow(Optional<T> obj, String errorMessage) {
        if (!(!isNull(obj) && obj.isPresent())) throw new NotFoundException(errorMessage);
    }

    public static void isNullAndNotFoundThrow(Object obj, String errorMessage) {
        if (isNull(obj)) throw new NotFoundException(errorMessage);
    }
}
