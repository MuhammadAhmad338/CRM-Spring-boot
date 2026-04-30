package com.example.firstspringproject.Repository;

import com.example.firstspringproject.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}