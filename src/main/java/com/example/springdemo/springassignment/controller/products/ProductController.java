package com.example.springdemo.springassignment.controller.products;

import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.exceptions.NotFoundException;
import com.example.springdemo.springassignment.service.ProductService;
import com.example.springdemo.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/products", method = {RequestMethod.GET, RequestMethod.POST})
public class ProductController {

    public void dealWithExceptions(Products theProduct){
        Products product = productService.findById(theProduct.getId());
        if(product==null){
            throw new NotFoundException("product id not found"+theProduct.getId());
        }
    }

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    public String role(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getName().startsWith("admin")){
            return  "admin";
        }
        else
            return  "ROLE_USER";
    }


    @GetMapping("/list")
    public String listProducts(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("role",auth.getAuthorities());
        model.addAttribute("products",productService.findAll());
        model.addAttribute("role",role());
        return "list-products";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        if(role()=="ROLE_USER"){
            throw new NotFoundException("users cannot access this page");
        }

        // create model attribute to bind form data
        Products theProduct = new Products();

        model.addAttribute("products", theProduct);

        return "product-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("products") Products theProduct )
    {
//        dealWithExceptions(theProduct);
        productService.save(theProduct);
        return "redirect:/products/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("productId") int id, Model model)
    {
        Products theProduct = productService.findById(id);
        dealWithExceptions(theProduct);
        model.addAttribute("products",theProduct);
        return "product-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id)
    {
        Products theProduct = productService.findById(id);
        dealWithExceptions(theProduct);
        productService.deleteById(id);

        return "redirect:/products/list";
    }




}
