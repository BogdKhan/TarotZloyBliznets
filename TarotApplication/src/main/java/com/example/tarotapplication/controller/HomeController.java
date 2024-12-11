package com.example.tarotapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.security.core.context.SecurityContextHolder;
import com.example.tarotapplication.service.UserService;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage() {
        return "home";  // Создайте страницу home.html в templates
    }
}