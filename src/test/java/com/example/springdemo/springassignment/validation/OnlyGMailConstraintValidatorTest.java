package com.example.springdemo.springassignment.validation;

import com.example.springdemo.springassignment.config.SecurityWebAppInitializer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OnlyGMailConstraintValidatorTest {

    @MockBean
    OnlyGMail onlyGMail;

    @MockBean
    ConstraintValidatorContext context;

    @Test
    void testOnlyGmail(){
        Mockito.when(onlyGMail.value()).thenReturn("gmail.com");
        OnlyGMailConstraintValidator onlyGMailConstraintValidator = new OnlyGMailConstraintValidator();
        onlyGMailConstraintValidator.initialize(onlyGMail);

        boolean result = onlyGMailConstraintValidator.isValid("shaw@gmail.com", context);
        Assertions.assertThat(result).isTrue();

        result = onlyGMailConstraintValidator.isValid("shaw@yahoo.com", context);
        Assertions.assertThat(result).isFalse();
    }

    @Test
    void security(){
        SecurityWebAppInitializer s=new SecurityWebAppInitializer();
    }

}