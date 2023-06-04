package com.example.booking_backend.authority.dto.request;

import lombok.Data;

@Data
public class LoginForm {
    private String username;
    private String password;
}
