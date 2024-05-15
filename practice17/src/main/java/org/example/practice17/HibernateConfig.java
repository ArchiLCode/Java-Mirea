package org.example.practice17;

import lombok.AllArgsConstructor;
import org.example.practice17.repositories.FeedbackRepository;
import org.example.practice17.repositories.ProductRepository;
import org.example.practice17.services.FeedbackService;
import org.example.practice17.services.ProductService;
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

    @Bean
    public FeedbackService feedbackService() throws SQLException {
        return new FeedbackService(feedbackRest());
    }

    @Bean
    public FeedbackRepository feedbackRest() throws SQLException {
        return new FeedbackRepository(ds);
    }
}
