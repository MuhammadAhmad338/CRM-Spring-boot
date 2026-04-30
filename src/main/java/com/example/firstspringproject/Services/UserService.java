package com.example.firstspringproject.Services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.firstspringproject.Models.User;
import com.example.firstspringproject.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;
    public UserService(UserRepository repo) {
        this.repo = repo;
    }
    public List<User> getAllUsers() {
        return repo.findAll();
    }
    public User saveUser(User user) {
        return repo.save(user);
    }

}