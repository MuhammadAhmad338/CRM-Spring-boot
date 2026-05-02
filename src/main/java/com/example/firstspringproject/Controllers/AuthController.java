package com.example.firstspringproject.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.firstspringproject.Models.AuthResponse;
import com.example.firstspringproject.Models.LoginRequest;
import com.example.firstspringproject.Models.SignupRequest;
import com.example.firstspringproject.Services.AuthService;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return service.login(request); // ✅ directly return
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest request) {

        try {
            AuthResponse response = service.signup(request);
            return ResponseEntity.ok(response);

        } catch (RuntimeException ex) {
            return ResponseEntity
                    .badRequest()
                    .body(Map.of("message", ex.getMessage()));
        }
    }
}