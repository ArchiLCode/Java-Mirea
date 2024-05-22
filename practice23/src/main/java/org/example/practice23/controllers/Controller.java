package org.example.practice23.controllers;

import lombok.RequiredArgsConstructor;
import org.example.practice23.services.ServiceDB;
import org.example.practice23.entities.Feedback;
import org.example.practice23.entities.Product;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ServiceDB service;


    @GetMapping("/")
    public String start() {
        return "index";
    }

    @GetMapping("/search/{name}")
    public Iterable<Feedback> getSpecificFeedback(@PathVariable String name) {
        return service.getSpecificFeedback(name);
    }

    @GetMapping("/products")
    @ResponseBody
    public Iterable<Product> getProducts() throws SQLException {
        return service.getProducts();
    }

    @PostMapping("/add-product")
    @ResponseBody
    public Product addProduct(@RequestBody Product product) throws SQLException {
        return service.addProduct(product);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteProduct(@PathVariable int id) throws SQLException {
        service.deleteProduct(id);
    }

    @GetMapping("/feedbacks")
    @ResponseBody
    public Iterable<Feedback> getFeedbacks() throws SQLException {
        return service.getFeedbacks();
    }

    @PostMapping("/add-feedback")
    @ResponseBody
    public Feedback addFeedback(@RequestBody Feedback feedback) throws SQLException {
        return service.addFeedback(feedback);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteFeedback(@PathVariable int id) throws SQLException {
        service.deleteFeedback(id);
    }
}
