package com.products.core.domain.aggregates.product.events;

import an.awesome.pipelinr.Notification;
import com.products.core.domain.aggregates.product.Product;
import com.products.core.shared.BaseDomainEvent;
import com.products.core.shared.validators.CustomValidator;

import javax.validation.constraints.NotNull;

public class SavedProductEvent extends BaseDomainEvent implements Notification {

    @NotNull(message = "The product is invalid")
    private final Product product;

    public SavedProductEvent(Product product) {
        this.product = product;
        this.validate();
    }

    private void validate() {
        CustomValidator.validateAndThrow(this);
        CustomValidator.validateAndThrow(this.product);
    }

    public Product getProduct() {
        return product;
    }
}
