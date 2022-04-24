package com.example.springdemo.springassignment.controller.products;

import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.entity.User;
import com.example.springdemo.springassignment.repository.ProductRepository;
import com.example.springdemo.springassignment.repository.UserRepository;
import com.example.springdemo.springassignment.service.ProductService;
import com.example.springdemo.springassignment.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductControllerTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testLoadByProductId() {
        Products product = new Products( "eraser", "2");

        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        Assert.assertEquals(product.getId(), productService.findById(product.getId()).getId());
    }

    @Test
    public void testFindAllUsers() {
        when(productRepository.findAll()).thenReturn(Stream.of(new Products("eraser", "2")).collect(Collectors.toList()));

        assertEquals(1, productService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        Products s = new Products("erasre", "2");
        productService.deleteById(s.getId());
        assertEquals(true,productRepository.findById(s.getId())!=null);
    }

}