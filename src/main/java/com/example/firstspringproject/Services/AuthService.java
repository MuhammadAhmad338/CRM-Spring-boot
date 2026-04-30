package com.example.firstspringproject.Services;

import org.springframework.stereotype.Service;
import com.example.firstspringproject.Models.User;
import com.example.firstspringproject.Models.LoginRequest;
import com.example.firstspringproject.Models.SignupRequest;
import com.example.firstspringproject.Repository.AuthRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class AuthService {

    private final AuthRepository repo;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    // SIGNUP
    public User signup(SignupRequest request) {

        if (repo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        return repo.save(user);
    }

    // LOGIN
    public User login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return user;
    }
}