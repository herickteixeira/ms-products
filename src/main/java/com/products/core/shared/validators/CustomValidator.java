package com.products.core.shared.validators;

import com.products.core.shared.exceptions.DomainException;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class CustomValidator {

    private CustomValidator() {
        throw new IllegalStateException("Custom Validator");
    }

    public static void validateAndThrow(boolean condition, String errorMessage) {
        if (condition) {
            throw new DomainException(errorMessage);
        }
    }

    public static void validateAndThrow(BooleanSupplier condition, String errorMessage) {
        CustomValidator.validateAndThrow(condition.getAsBoolean(), errorMessage);
    }

    public static void validateAndThrow(Object obj) {
        ObjectValidator.isNullAndThrow(obj, "object.validated.not.null");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        var validator = factory.getValidator();
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        var errorMessages = new ArrayList<String>();

        for (ConstraintViolation<Object> violation : violations)
            errorMessages.add(violation.getMessage());

        if (!errorMessages.isEmpty()) throw new DomainException(errorMessages);
    }
}
