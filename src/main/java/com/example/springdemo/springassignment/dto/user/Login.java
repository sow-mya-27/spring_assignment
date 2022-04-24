package com.example.springdemo.springassignment.dto.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {
    @NotNull(message = "username is required")
    @Size(min = 4, message = "at least 4 characters")
    private String username;

    @NotNull(message = "password is required")
    @Size(min = 6, message = "at least 6 characters")
    private String password;

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
}