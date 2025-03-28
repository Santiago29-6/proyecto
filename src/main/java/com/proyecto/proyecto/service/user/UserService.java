package com.proyecto.proyecto.service.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.dto.request.UserRequestDTO;
import com.proyecto.proyecto.dto.response.UserResponseDTO;
import com.proyecto.proyecto.enums.*;

@Service
public interface UserService {

    UserResponseDTO saveUser(UserRequestDTO userRequestDTO);

    UserResponseDTO findByUsername(String username);

    void changeRole(Role newRole, String username);

    UserResponseDTO findByUsernameReturnToken(String username);

    List<UserResponseDTO> findAllUsers();

    boolean deleteUser(Long id);

    UserResponseDTO findUserById(Long id);

    UserResponseDTO checkIfUsernameExists(String username);

}
