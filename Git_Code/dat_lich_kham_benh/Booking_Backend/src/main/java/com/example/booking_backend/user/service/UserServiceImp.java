package com.example.booking_backend.user.service;

import com.example.booking_backend.user.IUserRepository;
import com.example.booking_backend.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImp implements IUserService{
    @Autowired
    private IUserRepository iUserRepository;
    @Override
    @Transactional
    public void save(User user) {
        iUserRepository.save(user);
    }
}
