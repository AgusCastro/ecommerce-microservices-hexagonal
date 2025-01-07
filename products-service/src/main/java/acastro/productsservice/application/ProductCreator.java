package acastro.productsservice.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import acastro.productsservice.domain.events.ProductCreatedEvent;
import acastro.productsservice.domain.model.Product;
import acastro.productsservice.domain.driverports.CreateProductPort;
import acastro.productsservice.domain.drivenports.ProductEmitterPort;
import acastro.productsservice.domain.drivenports.ProductRepositoryPort;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductCreator implements CreateProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    private final ProductEmitterPort productEmitterPort;

    @Override
    public Optional<Product> createProduct(Product product) {
        final Optional<Product> optionalProduct = productRepositoryPort.save(product);
        if (optionalProduct.isPresent()) {
            final Product productCreated = optionalProduct.get();
            // TODO: call the event emitter port asynchronously
            productEmitterPort.emitProductCreatedEvent(new ProductCreatedEvent(productCreated.getProductId(), productCreated.getStock()));
        }
        return optionalProduct;
    }
}
