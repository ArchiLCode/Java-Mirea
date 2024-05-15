package org.example.practice15;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@AllArgsConstructor
public class HibernateConfig {
    private final DataSource ds;
    @Bean
    public ProductService productService() throws SQLException {
        return new ProductService(productRest());
    }

    @Bean
    public ProductRepository productRest() throws SQLException {
        ProductRepository productRepository = new ProductRepository(ds);
        productRepository.init();
        return productRepository;
    }
}
