package acastro.productsservice.infrastructure.persistence.nosql.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "acastro.productsservice.infrastructure.persistence.nosql.repository")
public class MongoConfiguration {
}
