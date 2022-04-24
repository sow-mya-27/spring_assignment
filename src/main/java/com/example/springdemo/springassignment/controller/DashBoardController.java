package com.example.springdemo.springassignment.controller;

import com.example.springdemo.springassignment.dto.CartModel;
import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.service.ProductService;
import com.example.springdemo.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class DashBoardController {


    @GetMapping("/")
    public String sh(Model model, HttpServletRequest request){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth.getName().startsWith("admin")){
            model.addAttribute("role",("admin"));
        }
        else
            model.addAttribute("role","ROLE_USER");
        if(request.getSession().getAttribute("cart") == null){
            request.getSession().setAttribute("cart", new CartModel());
        }
        return "customer";
    }


}
