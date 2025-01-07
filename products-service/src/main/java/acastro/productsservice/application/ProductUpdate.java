package acastro.productsservice.application;

import java.util.Optional;

import org.springframework.stereotype.Component;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.domain.driverports.UpdateProductPort;
import acastro.productsservice.domain.drivenports.ProductRepositoryPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ProductUpdate implements UpdateProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    @Override
    public Optional<Product> updateProduct(String productId, Integer quantity) {
        log.info("Updating product stock: productId={}, quantity={}", productId, quantity);
        final Product product = productRepositoryPort.findProductByProductId(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStock(quantity);

        log.info("Product updated: {}", product);
        return productRepositoryPort.save(product);
    }
}
