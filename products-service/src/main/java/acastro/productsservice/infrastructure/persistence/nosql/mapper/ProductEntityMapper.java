package acastro.productsservice.infrastructure.persistence.nosql.mapper;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.infrastructure.persistence.nosql.entities.ProductEntity;

public class ProductEntityMapper {

    public static Product toProduct(ProductEntity productEntity) {
        return new Product(
            productEntity.getProductId(),
            productEntity.getName(),
            productEntity.getDescription(),
            productEntity.getCategory(),
            productEntity.getPrice(),
            productEntity.getStock(),
            productEntity.getAttributes()
        );
    }

    public static ProductEntity toProductEntity(Product product) {
        return new ProductEntity(
            product.getProductId(),
            product.getName(),
            product.getDescription(),
            product.getCategory(),
            product.getPrice(),
            product.getStock(),
            product.getAttributes()
        );
    }
}
