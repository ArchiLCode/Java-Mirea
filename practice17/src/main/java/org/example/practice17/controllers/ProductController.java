package org.example.practice17.controllers;

import lombok.RequiredArgsConstructor;
import org.example.practice17.entities.Feedback;
import org.example.practice17.entities.Product;
import org.example.practice17.services.FeedbackService;
import org.example.practice17.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final ProductService service;
    private final FeedbackService feedbackService;


    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("/search/{name}")
    public List<Feedback> getSpecificFeedback(@PathVariable String name) {
        return feedbackService.getSpecificFeedback(name);
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getProducts() throws SQLException {
        return service.getProducts();
    }

    @PostMapping("/add-product")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) throws SQLException {
        return service.addProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean deleteProduct(@PathVariable int id) throws SQLException {
        return service.deleteProduct(id);
    }

    @GetMapping("/feedbacks")
    @ResponseBody
    public List<Feedback> getFeedbacks() throws SQLException {
        return feedbackService.getFeedbacks();
    }

    @PostMapping("/add-feedback")
    @ResponseBody
    public Feedback addFeedback(@RequestBody Feedback feedback) throws SQLException {
        return feedbackService.addFeedback(feedback);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean deleteFeedback(@PathVariable int id) throws SQLException {
        return feedbackService.deleteFeedback(id);
    }
}
