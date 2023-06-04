package com.example.booking_backend.authority.service.auth;

import com.example.booking_backend.authority.Role;
import com.example.booking_backend.authority.constant.ERole;
import com.example.booking_backend.authority.dto.repository.JwtResponse;
import com.example.booking_backend.authority.dto.request.LoginForm;
import com.example.booking_backend.authority.dto.request.RegisterForm;
import com.example.booking_backend.authority.jwt.JwtProvider;
import com.example.booking_backend.authority.service.role.IRoleService;
import com.example.booking_backend.user.User;
import com.example.booking_backend.user.service.IUserService;
import com.example.booking_backend.user.userprincal.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImp implements IAuthService{

    @Autowired
    JwtProvider jwtProvider;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    IUserService userService;
    @Autowired
    IRoleService roleService;
    @Override
    public ResponseEntity<?> login(LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        UserPrinciple userDetails = (UserPrinciple) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(),
                userDetails.getId() , userDetails.getName(), userDetails.getEmail(), userDetails.getAvatar() ,
                userDetails.getAuthorities()
        ));
    }

    @Override
    public ResponseEntity<?> register(RegisterForm registerForm) {
            User user = new User();
            user.setName(registerForm.getName());
            user.setUsername(registerForm.getUsername());
            user.setPassword(passwordEncoder.encode(registerForm.getUsername()));
            user.setEmail(registerForm.getEmail());
            Set<Role> roles = new HashSet<>();
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
            roles.add(userRole);
            user.setRoles(roles);
            user.setCreateDateTime(LocalDateTime.now());
            userService.save(user);
            return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
    }
}
