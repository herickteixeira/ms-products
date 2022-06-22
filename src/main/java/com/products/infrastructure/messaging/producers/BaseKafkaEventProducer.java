package com.products.infrastructure.messaging.producers;

import com.products.core.shared.exceptions.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;

public abstract class BaseKafkaEventProducer {

    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseKafkaEventProducer.class);

    protected KafkaTemplate<String, String> kafkaTemplate;

    protected BaseKafkaEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    protected void send(String topic, String message) {
        var future = kafkaTemplate.send(topic, message);
        future.addCallback(getCallback());
        future.completable().join();
    }

    private ListenableFutureCallback<SendResult<String, String>> getCallback() {
        return new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message due to : {}", ex.getMessage());
                throw new MessageException(ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                LOGGER.info("Sent message with offset=[ {} ]", result.getRecordMetadata().offset());
            }
        };
    }
}
