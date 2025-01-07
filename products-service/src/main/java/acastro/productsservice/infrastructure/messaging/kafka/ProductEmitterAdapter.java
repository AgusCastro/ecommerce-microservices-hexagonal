package acastro.productsservice.infrastructure.messaging.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import acastro.productsservice.domain.events.ProductCreatedEvent;
import acastro.productsservice.domain.drivenports.ProductEmitterPort;
import acastro.productsservice.infrastructure.messaging.kafka.config.KafkaTopicsProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ProductEmitterAdapter implements ProductEmitterPort {

    private final KafkaTopicsProperties kafkaTopics;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public boolean emitProductCreatedEvent(ProductCreatedEvent event) {
        log.info("Emitting product created event: {}", event);
        kafkaTemplate.send(kafkaTopics.getProductCreated(), event);
        log.info("Product created event emitted: {}", event);
        return true;
    }
}
