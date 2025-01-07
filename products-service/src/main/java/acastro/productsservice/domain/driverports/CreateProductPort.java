package acastro.productsservice.domain.driverports;

import java.util.Optional;

import acastro.productsservice.domain.model.Product;

public interface CreateProductPort {
    Optional<Product> createProduct(Product product);
}
