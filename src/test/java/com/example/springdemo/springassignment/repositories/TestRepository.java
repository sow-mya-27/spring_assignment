package com.example.springdemo.springassignment.repositories;

import com.example.springdemo.springassignment.dto.orders.ProductDto;
import com.example.springdemo.springassignment.entity.Products;
import com.example.springdemo.springassignment.entity.User;
import com.example.springdemo.springassignment.repository.ProductRepository;
import com.example.springdemo.springassignment.repository.UserRepository;
import com.example.springdemo.springassignment.service.ProductService;
import com.example.springdemo.springassignment.service.UserService;
import com.example.springdemo.springassignment.service_implementation.UserServiceImpl;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@SpringBootTest
@RunWith(SpringRunner.class)
//@ExtendWith(MockitoExtension.class)
public class TestRepository {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;


    @Autowired
    private ProductService productService;

    @Test
    public void productRepoExistsById(){
        Products products=new Products("chocolate","15");
        Products u=productService.save(products);

        Products res=productService.findById(products.getId());

        assertThat(res).isNotNull();
    }

}
