package acastro.productsservice.domain.drivenports;

import java.util.Optional;
import java.util.Set;

import acastro.productsservice.domain.model.Product;

public interface ProductRepositoryPort {

    Optional<Product> findProductByProductId(String productId);
    Set<Product> findAllProducts();

    Optional<Product> save(Product product);
}
