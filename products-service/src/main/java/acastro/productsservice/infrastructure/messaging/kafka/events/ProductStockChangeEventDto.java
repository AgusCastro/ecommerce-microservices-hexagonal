package acastro.productsservice.infrastructure.messaging.kafka.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductStockChangeEventDto {

    private String productId;
    private Integer quantity;

}
