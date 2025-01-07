package acastro.productsservice.infrastructure.api.mapper;

import java.math.BigDecimal;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.infrastructure.api.dto.ProductDto;

public class ProductDtoMapper {

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
            product.getProductId(),
            product.getName(),
            product.getDescription(),
            product.getCategory(),
            product.getPrice().toPlainString(),
            product.getStock(),
            product.getAttributes()
        );
    }

    public static Product toProduct(ProductDto productDto) {
        return new Product(
            productDto.getProductId(),
            productDto.getName(),
            productDto.getDescription(),
            productDto.getCategory(),
            new BigDecimal(productDto.getPrice()),
            productDto.getStock(),
            productDto.getAttributes()
        );
    }
}
