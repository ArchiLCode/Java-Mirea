package org.example.practice21;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.practice21.entities.Feedback;
import org.example.practice21.entities.Product;
import org.example.practice21.repo.FeedbackRepository;
import org.example.practice21.repo.ProductRepository;

@org.springframework.stereotype.Service
@AllArgsConstructor
@Slf4j
public class Service {
    private ProductRepository productRepository;
    private FeedbackRepository feedbackRepository;
    private CustomEmailSender customEmailSender;

    public Iterable<Product> getProducts() {
        log.info("!!!  All products  !!!");
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        log.info("!!!  Add product  !!!");
        return productRepository.save(product);
    }

    public void deleteProduct(long id) {
        log.info("!!!  Delete product  !!!");
        productRepository.deleteById(id);
    }

    public Iterable<Feedback> getFeedbacks() {
        log.info("!!!  All feedbacks  !!!");
        return feedbackRepository.findAll();
    }

    public Feedback addFeedback(Feedback feedback) {
        log.info("!!!  Add feedback  !!!");
        customEmailSender.sendEmail(feedback);
        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(long id) {
        log.info("!!!  Delete feedback  !!!");
        feedbackRepository.deleteById(id);
    }

    public Iterable<Feedback> getSpecificFeedback(String name) {
        log.info("!!!  Get feedback by name  !!!");
        return feedbackRepository.findAllByName(name);
    }
}
