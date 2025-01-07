package acastro.productsservice.application;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.domain.driverports.QueryProductPort;
import acastro.productsservice.domain.drivenports.ProductRepositoryPort;

@Component
public class ProductQuery implements QueryProductPort {

    private final ProductRepositoryPort productRepositoryPort;

    public ProductQuery(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Product> findProductByProductId(String productId) {
        return productRepositoryPort.findProductByProductId(productId);
    }

    @Override
    public Set<Product> findAllProducts() {
        return productRepositoryPort.findAllProducts();
    }
}
