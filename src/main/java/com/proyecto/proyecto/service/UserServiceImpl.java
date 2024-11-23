package com.proyecto.proyecto.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.proyecto.proyecto.model.Role;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.repository.UserRepository;

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setFechaRegistro(LocalDateTime.now());
        User userCreated = userRepository.save(user);
        
        return userCreated;
    }
}
