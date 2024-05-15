package org.example.practice16.controllers;

import lombok.RequiredArgsConstructor;
import org.example.practice16.entities.Feedback;
import org.example.practice16.entities.Product;
import org.example.practice16.services.FeedbackService;
import org.example.practice16.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;
    private final FeedbackService feedbackService;


    @GetMapping("/")
    public String start() {
        return "index";
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

    @GetMapping("/subjects")
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
