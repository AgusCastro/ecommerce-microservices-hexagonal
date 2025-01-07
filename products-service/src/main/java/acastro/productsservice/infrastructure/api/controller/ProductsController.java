package acastro.productsservice.infrastructure.api.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import acastro.productsservice.domain.driverports.CreateProductPort;
import acastro.productsservice.domain.driverports.QueryProductPort;
import acastro.productsservice.infrastructure.api.dto.ProductDto;
import acastro.productsservice.infrastructure.api.exceptions.NotFoundException;
import acastro.productsservice.infrastructure.api.mapper.ProductDtoMapper;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductsController {

    public static final String PRODUCT_NOT_FOUND = "Product not found";

    private final QueryProductPort forQueryingProduct;

    private final CreateProductPort forCreatingProduct;

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable("productId") String productId) {
        return forQueryingProduct.findProductByProductId(productId)
            .map(ProductDtoMapper::toProductDto)
            .orElseThrow(() -> new NotFoundException(PRODUCT_NOT_FOUND));
    }

    @GetMapping("/")
    public Set<ProductDto> getAllProducts() {
        return forQueryingProduct.findAllProducts().stream()
            .map(ProductDtoMapper::toProductDto)
            .collect(java.util.stream.Collectors.toSet());
    }

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return forCreatingProduct.createProduct(ProductDtoMapper.toProduct(productDto))
            .map(ProductDtoMapper::toProductDto)
            .orElse(null);
    }
}
