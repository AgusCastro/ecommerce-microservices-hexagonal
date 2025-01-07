package acastro.productsservice.infrastructure.messaging.kafka;

import java.util.Optional;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.domain.driverports.UpdateProductPort;
import acastro.productsservice.infrastructure.messaging.kafka.events.ProductStockChangeEventDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ProductListenerAdapter {

    private final UpdateProductPort forUpdateProduct;

    @KafkaListener(topics = "${spring.kafka.topic.product-updates}", groupId = "${spring.kafka.consumer.group-id}", containerFactory = "productStockChangeEventListenerContainerFactory")
    public Optional<Product> produceUpdateProduct(ProductStockChangeEventDto productStockChangeEvent) {
        log.info("Product stock change event received: {}", productStockChangeEvent);
        return forUpdateProduct.updateProduct(productStockChangeEvent.getProductId(), productStockChangeEvent.getQuantity());
    }
}
