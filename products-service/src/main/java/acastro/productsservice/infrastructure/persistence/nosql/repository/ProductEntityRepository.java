package acastro.productsservice.infrastructure.persistence.nosql.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import acastro.productsservice.infrastructure.persistence.nosql.entities.ProductEntity;

@Repository
public interface ProductEntityRepository extends MongoRepository<ProductEntity, String> {

    Optional<ProductEntity> findByProductId(String productId);
}
