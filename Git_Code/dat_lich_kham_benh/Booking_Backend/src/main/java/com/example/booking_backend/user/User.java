package com.example.booking_backend.user;

import com.example.booking_backend.authority.Role;
import com.example.booking_backend.image.Image;
import com.example.booking_backend.user.constant.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(columnDefinition = "longtext")
    private String address;

    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String username;
    private String password;

    private LocalDateTime createDateTime;

    @ManyToMany
    @JoinTable(
            name = "user_images",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    private Set<Image> images;
    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;

    @Column(columnDefinition = "longtext")
    private String avatar;

}
