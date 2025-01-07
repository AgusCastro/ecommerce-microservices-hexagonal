package acastro.productsservice.infrastructure.persistence.nosql.entities;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Document(collection = "products")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductEntity {

    @Id
    private String productId;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private Map<String, String> attributes;

}
