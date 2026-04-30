package com.example.firstspringproject.Controllers;

import org.springframework.web.bind.annotation.*;
import com.example.firstspringproject.Models.LoginRequest;
import com.example.firstspringproject.Models.SignupRequest;
import com.example.firstspringproject.Services.AuthService;

import java.util.concurrent.Future;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public Future<Void> login(@RequestBody LoginRequest request) {
    service.login(request);
        return null;
    }

    @PostMapping("/signup")
    public Future<Void> signup(
            @RequestBody SignupRequest request) {
       service.signup(request);
       return null;
    }
}
