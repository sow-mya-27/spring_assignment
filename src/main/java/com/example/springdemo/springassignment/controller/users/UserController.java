package com.example.springdemo.springassignment.controller.users;

import com.example.springdemo.springassignment.dto.user.Signup;
import com.example.springdemo.springassignment.entity.User;
import com.example.springdemo.springassignment.exceptions.NotFoundException;
import com.example.springdemo.springassignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/users", method = {RequestMethod.GET, RequestMethod.POST})
public class UserController {

    @Autowired
    private UserService userService;


    public String role(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getName().startsWith("admin")){
            return  "admin";
        }
        else
            return  "ROLE_USER";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("users") Signup data, BindingResult result,Model model){
        if (result.hasErrors()) {
            return "signup";
        }
        User user;
        if(data.getUsername().startsWith("admin")){
            user=new User(data.getUsername(),data.getEmail(), "{noop}"+data.getPassword(),  "ROLE_ADMIN");
        }
        else {
            user=new User(data.getUsername(),data.getEmail(), "{noop}"+data.getPassword(),  "ROLE_USER");
        }
        userService.save(user);
        return "redirect:/showMyLoginPage";

    }

    @GetMapping("/list")
    public String listUser(Model model){
        model.addAttribute("role",role());
        model.addAttribute("users",userService.findAll());
        return "list-users";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        if(role()=="ROLE_USER"){
            throw new NotFoundException("users cannot access this page");
        }

        // create model attribute to bind form data
        User theUser = new User();

        model.addAttribute("users", theUser);

        return "user-form";
    }

    @PostMapping("/saveCrud")
    public String save(@Valid @ModelAttribute("users") User theUser , Errors errors)
    {
        if (null != errors && errors.getErrorCount() > 0) {
            return "user-form";
        } else {
            userService.save(theUser);
            return "redirect:/users/list";
        }

    }

    @GetMapping("/showFormForUpdate")
        public String showFormForUpdate(@RequestParam("userId") int id, Model model)
    {
        User theUser = userService.findById(id);
        if(theUser==null){
            throw new NotFoundException("customer id not found"+id);
        }
        model.addAttribute("users",theUser);
        return "user-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("userId") int id)
    {
        User theUser = userService.findById(id);
        if(theUser==null){
            throw new NotFoundException("customer id not found"+id);
        }
        userService.deleteById(id);

        return "redirect:/users/list";
    }

}
