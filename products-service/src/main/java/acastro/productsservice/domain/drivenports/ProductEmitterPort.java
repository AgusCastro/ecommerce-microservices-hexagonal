package acastro.productsservice.domain.drivenports;

import acastro.productsservice.domain.events.ProductCreatedEvent;

public interface ProductEmitterPort {

    boolean emitProductCreatedEvent(ProductCreatedEvent event);
}
