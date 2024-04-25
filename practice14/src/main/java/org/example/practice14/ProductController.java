package org.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("prac14")
public class ProductController {
    private List<Product> products = new ArrayList<>();

    @GetMapping("/home")
    public String start() {
        return "index";
    }

    @PostMapping("/add-product")
    @ResponseBody
    public Product createProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return products;
    }

    @DeleteMapping("/products/{index}")
    @ResponseBody
    public Product deleteProduct(@PathVariable int index) {
        if (index >= 0 && index < products.size()) {
            return products.remove(index);
        } else {
            return null;
        }
    }
}
