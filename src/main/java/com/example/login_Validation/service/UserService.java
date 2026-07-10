package com.example.login_Validation.service;

import com.example.login_Validation.entity.User;
import com.example.login_Validation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public User login(String email) {
        return repository.findByEmail(email);
    }
}