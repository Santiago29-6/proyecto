package com.proyecto.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Role;
import com.proyecto.proyecto.model.User;

@Service
public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    User findByUsernameReturnToken(String username);

    List<User> findAllUsers();

}
