package com.example.booking_backend.authority;

import com.example.booking_backend.authority.dto.request.LoginForm;
import com.example.booking_backend.authority.dto.request.RegisterForm;
import com.example.booking_backend.authority.service.auth.IAuthService;
import com.example.booking_backend.authority.service.role.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private IAuthService authService;
    @Autowired
    private IRoleService roleService;
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        return this.authService.login(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterForm registerForm) {

        return this.authService.register(registerForm);
    }
}
