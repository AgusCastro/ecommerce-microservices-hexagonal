package acastro.productsservice.domain.driverports;

import java.util.Optional;
import java.util.Set;

import acastro.productsservice.domain.model.Product;

public interface QueryProductPort {

    Optional<Product> findProductByProductId(String productId);
    Set<Product> findAllProducts();
}
