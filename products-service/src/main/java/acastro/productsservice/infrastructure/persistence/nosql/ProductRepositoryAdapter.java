package acastro.productsservice.infrastructure.persistence.nosql;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import acastro.productsservice.domain.model.Product;
import acastro.productsservice.domain.drivenports.ProductRepositoryPort;
import acastro.productsservice.infrastructure.persistence.nosql.mapper.ProductEntityMapper;
import acastro.productsservice.infrastructure.persistence.nosql.repository.ProductEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductEntityRepository productEntityRepository;

    @Override
    public Optional<Product> findProductByProductId(String productId) {
        return productEntityRepository.findByProductId(productId)
            .map(ProductEntityMapper::toProduct);
    }

    @Override
    public Set<Product> findAllProducts() {
        return productEntityRepository.findAll()
            .stream()
            .map(ProductEntityMapper::toProduct)
            .collect(Collectors.toSet());
    }

    @Override
    public Optional<Product> save(Product product) {
        log.info("Saving product: {}", product);
        return Optional.of(productEntityRepository.save(ProductEntityMapper.toProductEntity(product)))
            .map(ProductEntityMapper::toProduct);
    }
}
