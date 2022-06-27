package com.products.core.domain.aggregates.product.events;

import an.awesome.pipelinr.Notification;
import com.products.core.shared.BaseDomainEvent;

public class ErrorSaveProductEvent extends BaseDomainEvent implements Notification {

    private final String message;

    public ErrorSaveProductEvent(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
