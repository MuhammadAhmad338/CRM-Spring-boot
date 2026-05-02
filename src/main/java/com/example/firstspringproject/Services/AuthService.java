package com.example.firstspringproject.Services;

import com.example.firstspringproject.AppConfig.JwtService;
import com.example.firstspringproject.Models.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private JwtService jwtService;

    public AuthService(AuthRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    // SIGNUP
    public AuthResponse signup(SignupRequest request) {

        if (repo.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        User savedUser = repo.save(user);

        String token = jwtService.generateToken(savedUser.getEmail());

        return new AuthResponse(
                token,
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getUsername()
        );
    }
    // LOGIN
    public AuthResponse login(LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }



            String token = jwtService.generateToken(user.getEmail());

            return new AuthResponse(
                    token,
                    user.getId(),
                    user.getEmail(),
                    user.getUsername()
            );


    }
}