package com.example.springdemo.springassignment.dto.user;


import javax.validation.constraints.*;
import com.example.springdemo.springassignment.validation.OnlyGMail;

public class Signup {
    @NotNull(message = "is required")
    @Size(min = 4, message = "Minimum 4 characters")
    private String username;

    @NotNull(message = "is required")
    @Size(min = 6, message = "Minimum 6 characters")
    private String password;

    @NotNull(message = "is required")
    private String confirmPassword;

    @NotNull(message = "is required")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Provide a valid Email")
    @OnlyGMail
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
