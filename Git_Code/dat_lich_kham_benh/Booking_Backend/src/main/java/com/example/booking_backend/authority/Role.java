package com.example.booking_backend.authority;

import com.example.booking_backend.authority.constant.ERole;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private ERole name;
}
