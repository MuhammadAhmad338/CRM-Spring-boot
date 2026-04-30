package com.example.firstspringproject.Repository;

import com.example.firstspringproject.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}