package acastro.productsservice.infrastructure.messaging.kafka.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "spring.kafka.topic")
@Getter
@Setter
public class KafkaTopicsProperties {

    private String productUpdates;

    private String productCreated;

}
