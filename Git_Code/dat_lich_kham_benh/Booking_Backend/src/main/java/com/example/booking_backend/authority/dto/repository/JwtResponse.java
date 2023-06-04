package com.example.booking_backend.authority.dto.repository;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    private Long id;
    private String token;
    private String type = "Bearer";
    private String username;
    private String name;
    private String email;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;

    public JwtResponse(String token, String type, String username, String name, String email, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.name = name;
        this.email = email;
        this.avatar = avatar;
        this.roles = roles;
    }
}
