package com.example.firstspringproject.Services;

import org.springframework.stereotype.Service;
import com.example.firstspringproject.Models.Product;
import com.example.firstspringproject.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product saveProduct(Product user) {
        return repo.save(user);
    }
}