package acastro.productsservice.domain.driverports;

import java.util.Optional;

import acastro.productsservice.domain.model.Product;

public interface UpdateProductPort {
    Optional<Product> updateProduct(String productId, Integer quantity);
}
