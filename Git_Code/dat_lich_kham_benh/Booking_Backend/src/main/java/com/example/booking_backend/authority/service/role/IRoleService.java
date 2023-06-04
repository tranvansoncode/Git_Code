package com.example.booking_backend.authority.service.role;

import com.example.booking_backend.authority.Role;
import com.example.booking_backend.authority.constant.ERole;

import java.util.Optional;

public interface IRoleService {

    Optional<Role> findByName(ERole eRole);
}
