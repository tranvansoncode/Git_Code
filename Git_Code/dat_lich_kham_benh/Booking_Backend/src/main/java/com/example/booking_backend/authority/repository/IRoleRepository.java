package com.example.booking_backend.authority.repository;

import com.example.booking_backend.authority.Role;
import com.example.booking_backend.authority.constant.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole eRole);
}
