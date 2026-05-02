package com.example.firstspringproject.Models;

public class AuthResponse {

    private String token;
    private Long id;
    private String email;
    private String username;

    public AuthResponse(String token, Long id, String email, String username) {
        this.token = token;
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public String getToken() { return token; }
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getUsername() { return username; }
}
