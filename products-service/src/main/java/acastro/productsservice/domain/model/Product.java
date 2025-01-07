package acastro.productsservice.domain.model;

import java.math.BigDecimal;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Product {

    private String productId;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    @Setter
    private Integer stock;
    private Map<String, String> attributes;

}
