package com.products.core.events;

import an.awesome.pipelinr.Notification;
import com.products.core.domain.aggregates.product.ProductResponseMapper;
import com.products.core.domain.aggregates.product.events.SavedProductEvent;
import com.products.core.shared.converters.JsonConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SavedProductsEventHandler implements Notification.Handler<SavedProductEvent> {

    private final SavedProductProducer savedProductProducer;

    @Autowired
    public SavedProductsEventHandler(SavedProductProducer savedProductProducer) {
        this.savedProductProducer = savedProductProducer;
    }

    @Override
    public void handle(SavedProductEvent event) {
        var productResponse = ProductResponseMapper.map(event.getProduct());
        var message = JsonConverter.toString(productResponse);
        savedProductProducer.produce(message);
    }
}
