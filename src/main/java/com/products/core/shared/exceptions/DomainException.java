package com.products.core.shared.exceptions;

import java.util.ArrayList;
import java.util.List;

public class DomainException extends RuntimeException {
    private final List<String> errorMessages;

    public DomainException(List<String> errorMessages) {
        this.errorMessages = errorMessages;
    }

    public DomainException(String errorMessage) {
        super(errorMessage);
        this.errorMessages = new ArrayList<>();
        this.errorMessages.add(errorMessage);
    }

    public List<String> getMessages() {
        return errorMessages;
    }
}
