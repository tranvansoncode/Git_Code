package com.example.booking_backend.authority.service.auth;

import com.example.booking_backend.authority.dto.request.LoginForm;
import com.example.booking_backend.authority.dto.request.RegisterForm;
import org.springframework.http.ResponseEntity;

public interface IAuthService {
    ResponseEntity<?> login(LoginForm loginRequest);

    ResponseEntity<?> register(RegisterForm registerForm);
}
