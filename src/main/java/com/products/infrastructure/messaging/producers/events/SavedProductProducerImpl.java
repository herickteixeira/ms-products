package com.products.infrastructure.messaging.producers.events;

import com.products.core.events.SavedProductProducer;
import com.products.infrastructure.messaging.producers.BaseKafkaEventProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SavedProductProducerImpl extends BaseKafkaEventProducer implements SavedProductProducer {

    private final String productsEventTopic;

    @Autowired
    protected SavedProductProducerImpl(
            @Value("${kafka.topics.events.products}") String productsEventTopic,
            KafkaTemplate<String, String> kafkaTemplate) {
        super(kafkaTemplate);
        this.productsEventTopic = productsEventTopic;
    }

    @Override
    public void produce(String message) {
        super.send(productsEventTopic, message);
    }
}
