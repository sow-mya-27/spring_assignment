package com.example.springdemo.springassignment.service_implementation;

import com.example.springdemo.springassignment.entity.User;
import com.example.springdemo.springassignment.repository.UserRepository;
import com.example.springdemo.springassignment.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void testLoadByUserId() {
        User user = new User( "test1", "test1@gmail.com","test1", "ROLE_ADMIN");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        Assert.assertEquals(user.getId(), userService.findById(user.getId()).getId());
    }

    @Test
    public void testFindAllUsers() {
        when(userRepository.findAll()).thenReturn(Stream.of(new User("Test", "test@test.com", "CSE", "ROLE_USER")).collect(Collectors.toList()));

        assertEquals(1, userService.findAll().size());
    }

    @Test
    public void testDeleteById() {
        User s = new User("test1", "test1@gmail.com", "test1", "ROLE_ADMIN");
        userService.deleteById(s.getId());
        assertEquals(true,userRepository.findById(s.getId())!=null);
    }


}