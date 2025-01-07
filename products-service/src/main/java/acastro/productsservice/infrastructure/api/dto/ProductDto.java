package acastro.productsservice.infrastructure.api.dto;

import java.util.Map;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductDto {

    private String productId;
    private String name;
    private String description;
    private String category;
    private String price;
    private Integer stock;
    private Map<String, String> attributes;

}
