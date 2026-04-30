package com.example.firstspringproject.Controllers;

import com.example.firstspringproject.Models.User;
import com.example.firstspringproject.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        System.out.println(user);
        System.out.println(user);
        return service.saveUser(user);
    }
}
