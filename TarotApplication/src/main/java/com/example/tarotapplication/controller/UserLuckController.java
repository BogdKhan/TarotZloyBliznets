package com.example.tarotapplication.controller;

import com.example.tarotapplication.model.UserLuck;
import com.example.tarotapplication.service.UserLuckService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.security.core.context.SecurityContextHolder;


@Controller
public class UserLuckController {
    private final UserLuckService userLuckService;

    // Constructor for dependency injection
    public UserLuckController(UserLuckService userLuckService) {
        this.userLuckService = userLuckService;
    }
    
    @GetMapping("/profile")
    public String profileDisplay(Model model) {
        try {
            userLuckService.addLuck(new UserLuck());
        }
        catch (RuntimeException e) {}
        model.addAttribute("message", SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("luck", userLuckService.getCurrentUserLuck());
        return "profile";
    }

    @PostMapping("/add")
    public String changeLuck() {
        Integer random = (int) (Math.random()*10);
        if (userLuckService.getCurrentUserLuck() + random > 50) {}
        else {
           userLuckService.changeLuckWithCurrentUser(random);
        }
        return "redirect:/profile";
    }
}