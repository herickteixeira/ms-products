package com.products.core.shared.validators;

import com.products.core.shared.exceptions.NotFoundException;

import java.util.List;

public class ListValidator {

    private ListValidator() {
        throw new IllegalStateException("List Validator");
    }

    public static <T> boolean isEmpty(List<T> lists) {
        return !((lists != null) && !lists.isEmpty());
    }

    public static <T> void isEmptyAndThrow(List<T> lists, String errorMessage) {
        CustomValidator.validateAndThrow(isEmpty(lists), errorMessage);
    }

    public static <T> void isEmptyAndNotFoundThrow(List<T> lists, String errorMessage) {
        if (isEmpty(lists)) throw new NotFoundException(errorMessage);
    }
}
