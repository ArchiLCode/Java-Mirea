package org.example.practice24;

import org.example.practice24.entities.Feedback;
import org.example.practice24.entities.Product;
import org.example.practice24.repo.FeedbackRepository;
import org.example.practice24.repo.ProductRepository;
import org.example.practice24.services.ServiceDB;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class ServiceDBTests {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private FeedbackRepository feedbackRepository;

    @InjectMocks
    private ServiceDB serviceDB;

    @Test
    public void getProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Prod1", 100));
        products.add(new Product(2, "Prod2", 200));

        Mockito.when(productRepository.findAll()).thenReturn(products);

        Iterable<Product> productIterable = serviceDB.getProducts();
        List<Product> productList = new ArrayList<>();
        productIterable.forEach(productList::add);

        assertEquals(2, productList.size());
    }

    @Test
    public void addProduct() {
        Product product = new Product(1, "Prod1", 100);

        Mockito.when(productRepository.save(product)).thenReturn(product);

        assertEquals(product, serviceDB.addProduct(product));
    }

    @Test
    public void deleteProduct() {
        long productId = 1;

        Mockito.doNothing().when(productRepository).deleteById(productId);

        Assertions.assertDoesNotThrow(() -> serviceDB.deleteProduct(productId));
    }

    @Test
    public void getFeedbacks() {
        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.add(new Feedback(1, "Alex", "Good", 1));
        feedbacks.add(new Feedback(2, "Jane", "Well", 2));

        Mockito.when(feedbackRepository.findAll()).thenReturn(feedbacks);

        Iterable<Feedback> feedbackIterable = serviceDB.getFeedbacks();
        List<Feedback> feedbackList = new ArrayList<>();
        feedbackIterable.forEach(feedbackList::add);

        assertEquals(2, feedbackList.size());
    }

    @Test
    public void addFeedback() {
        Feedback feedback = new Feedback(1, "Alex", "Good", 1);

        Mockito.when(feedbackRepository.save(feedback)).thenReturn(feedback);

        assertEquals(feedback, serviceDB.addFeedback(feedback));
    }

    @Test
    public void deleteFeedback() {
        long feedbackId = 1;

        Mockito.doNothing().when(feedbackRepository).deleteById(feedbackId);

        Assertions.assertDoesNotThrow(() -> serviceDB.deleteFeedback(feedbackId));
    }

    @Test
    public void getSpecificFeedback() {
        String feedbackName = "Math";
        Feedback feedback = new Feedback(1, "Alex", "Good", 1);

        List<Feedback> feedbacks = new ArrayList<>();
        feedbacks.add(feedback);

        Mockito.when(serviceDB.getSpecificFeedback(feedbackName)).thenReturn(feedbacks);

        List<Feedback> result = (List<Feedback>) serviceDB.getSpecificFeedback(feedbackName);

        assertEquals(1, result.size());
        //assertEquals(feedback, result.getFirst());
    }
}