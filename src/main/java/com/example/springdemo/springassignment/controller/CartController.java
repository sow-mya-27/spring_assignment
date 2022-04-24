package com.example.springdemo.springassignment.controller;

import com.example.springdemo.springassignment.dto.CartModel;
import com.example.springdemo.springassignment.dto.orders.OrderProductDto;
import com.example.springdemo.springassignment.dto.orders.ProductDto;
import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.exceptions.NotFoundException;
import com.example.springdemo.springassignment.repository.ProductRepository;
import com.example.springdemo.springassignment.service.ProductService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ProductService productService;

    public void check(int id){
        Products theProduct = productService.findById(id);
        if(theProduct==null){
            throw new NotFoundException("product id not found"+id);
        }
    }
    public String role(){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth.getName().startsWith("admin")){
            return  "admin";
        }
        else
            return  "ROLE_USER";
    }

    @GetMapping("/addItem")
    public String addItem( @RequestParam("productId") Integer productId, Model model, HttpServletRequest request){
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cart");
        check(productId);
        if(productId!=null && productId!=0){
            Products products = productService.findById(productId);
//        System.out.println(cartModel.getTotalPrice());
            if(cartModel == null){
                System.out.println("null");
            }else{
                cartModel.addProduct(products);
            }
        }
        List<OrderProductDto> a=(cartModel.getOrderProductDtoList());
        ArrayList<ProductDto> products1=new ArrayList<>();
        ArrayList<Integer> quantity=new ArrayList<>();
        for(OrderProductDto o:a){
            products1.add(o.getProductDto());
            quantity.add(o.getQuantity());
        }
        model.addAttribute("cart", a);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("total",cartModel.getTotalPrice());
        return "list-cart";
    }

    @GetMapping("/increment")
    public String increment(@RequestParam("prodId") Integer productId,HttpServletRequest request,Model model){
        check(productId);
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cart");
        Products products = productService.findById(productId);
        ArrayList<ProductDto> products1=new ArrayList<>();
        List<OrderProductDto> a=(cartModel.getOrderProductDtoList());
        for(OrderProductDto o:a){
            products1.add(o.getProductDto());
        }
        model.addAttribute("cart", products1);
        cartModel.increment(productId,products);
        String url="productId="+productId;
        return "redirect:/cart/";
    }
    @GetMapping("/decrement")
    public String decrement(@RequestParam("prodId") Integer productId,HttpServletRequest request,Model model){

        check(productId);
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cart");
        Products products = productService.findById(productId);
        ArrayList<ProductDto> products1=new ArrayList<>();
        List<OrderProductDto> a=(cartModel.getOrderProductDtoList());
        for(OrderProductDto o:a){
            products1.add(o.getProductDto());
        }
        model.addAttribute("cart", products1);
        cartModel.decrement(productId,products);
        String url="productId="+productId;
//        return "redirect:/products/list";
        return "redirect:/cart/";
    }
    @GetMapping("/")
    public String cart(Model model, HttpServletRequest request){
        CartModel cartModel = (CartModel) request.getSession().getAttribute("cart");
        List<OrderProductDto> a=(cartModel.getOrderProductDtoList());
        ArrayList<ProductDto> products1=new ArrayList<>();
        ArrayList<Integer> quantity=new ArrayList<>();
        for(OrderProductDto o:a){
            products1.add(o.getProductDto());
            quantity.add(o.getQuantity());
        }
        model.addAttribute("cart", a);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("total",cartModel.getTotalPrice());
        return "list-cart";
    }
}
