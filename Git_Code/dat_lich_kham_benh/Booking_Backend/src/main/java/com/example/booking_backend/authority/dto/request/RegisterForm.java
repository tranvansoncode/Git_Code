package com.example.booking_backend.authority.dto.request;

import com.example.booking_backend.utils.annotation.NonExists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm {
    private String name;
    private String username;
    private String password;
    @NonExists
    private String email;
}
