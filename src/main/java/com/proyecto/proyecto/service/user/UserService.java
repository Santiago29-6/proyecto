package com.proyecto.proyecto.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.enums.*;
import com.proyecto.proyecto.model.User;

@Service
public interface UserService {

    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    User findByUsernameReturnToken(String username);

    List<User> findAllUsers();

    boolean deleteUser(Long id);

    Optional<User> findUserById(Long id);

    Optional<User> checkIfUsernameExists(String username);

}
