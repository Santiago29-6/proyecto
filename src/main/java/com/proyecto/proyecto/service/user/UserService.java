package com.proyecto.proyecto.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.request.UserRequestDTO;
import com.proyecto.proyecto.dto.response.UserResponseDTO;
import com.proyecto.proyecto.enums.*;
import com.proyecto.proyecto.model.User;

@Service
public interface UserService {

    UserResponseDTO saveUser(UserRequestDTO userRequestDTO);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);

    UserResponseDTO findByUsernameReturnToken(String username);

    List<UserResponseDTO> findAllUsers();

    boolean deleteUser(Long id);

    Optional<User> findUserById(Long id);

    Optional<User> checkIfUsernameExists(String username);

}
