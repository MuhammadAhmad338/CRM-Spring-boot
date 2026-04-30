package com.example.firstspringproject.Controllers;

import org.springframework.web.bind.annotation.*;
import com.example.firstspringproject.Models.Product;
import com.example.firstspringproject.Services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }
}

