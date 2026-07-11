package com.example.login_Validation.controller;

import org.springframework.validation.BindingResult;
import com.example.login_Validation.entity.User;
import com.example.login_Validation.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/saveUser")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            BindingResult result) {

        if(result.hasErrors()) {
            return "register";
        }

        service.saveUser(user);

        return "login";
    }

    @PostMapping("/loginUser")
    public String loginUser(
            @RequestParam String email,
            @RequestParam String password,
            Model model) {

        User user = service.login(email);

        if (user != null &&
                user.getPassword().equals(password)) {

            model.addAttribute("name",
                    user.getName());
            return "dashboard";
        }

        model.addAttribute("error",
                "Invalid Email or Password");

        return "login";
    }
}