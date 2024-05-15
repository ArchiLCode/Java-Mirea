package org.example.practice17.services;

import lombok.AllArgsConstructor;
import org.example.practice17.entities.Product;
import org.example.practice17.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public List<Product> getProducts() throws SQLException {
        return productRepository.getProducts();
    }
    public Product addProduct(Product product) throws SQLException {
        return productRepository.addProduct(product);
    }

    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }
}
