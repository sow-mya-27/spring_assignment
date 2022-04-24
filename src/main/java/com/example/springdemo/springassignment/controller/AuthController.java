package com.example.springdemo.springassignment.controller;

import com.example.springdemo.springassignment.dto.user.Signup;
import com.example.springdemo.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    @GetMapping("/showMyLoginPage")
    public String showLoginPage(Model mode){
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model){
        model.addAttribute("users",new Signup());
        return "signup";
    }


}
