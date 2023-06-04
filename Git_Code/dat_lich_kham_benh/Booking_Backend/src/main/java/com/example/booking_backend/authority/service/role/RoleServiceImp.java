package com.example.booking_backend.authority.service.role;

import com.example.booking_backend.authority.Role;
import com.example.booking_backend.authority.constant.ERole;
import com.example.booking_backend.authority.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements IRoleService{
    @Autowired
    private IRoleRepository iRoleRepository;
    @Override
    public Optional<Role> findByName(ERole eRole) {
        return iRoleRepository.findByName(eRole) ;
    }
}
