package org.example.practice18;

import lombok.AllArgsConstructor;
import org.example.practice18.entities.Feedback;
import org.example.practice18.entities.Product;
import org.example.practice18.repo.FeedbackRepository;
import org.example.practice18.repo.ProductRepository;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class Service {
    private ProductRepository productRepository;
    private FeedbackRepository feedbackRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public Iterable<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback addFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }

    public Iterable<Feedback> getSpecificFeedback(String name) {
        return feedbackRepository.findAllByName(name);
    }
}
