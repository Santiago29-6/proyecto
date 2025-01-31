package com.proyecto.proyecto.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.proyecto.constant.Message;
import com.proyecto.proyecto.dto.request.UserRequestDTO;
import com.proyecto.proyecto.dto.response.UserResponseDTO;
import com.proyecto.proyecto.enums.*;
import com.proyecto.proyecto.exception.NotFoundException;
import com.proyecto.proyecto.exception.UsernameAlreadyExistsException;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
            ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<UserResponseDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
            .map(u -> objectMapper.convertValue(u, UserResponseDTO.class))
            .toList();
    }

    @Override
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) {

        User user = objectMapper.convertValue(userRequestDTO, User.class);

        if (user.getId() != null) {
            findUserById(user.getId());
        } else {
            checkIfUsernameExists(user.getUsername());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        return objectMapper.convertValue(userRepository.save(user), UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO checkIfUsernameExists(String username) {
        User user = userRepository.findByUsername(username)
            .orElseThrow(
                () -> new UsernameAlreadyExistsException(String.format(Message.USERNAME_ALREADY_EXIST, username))
            );
        UserResponseDTO userResponseDTO = objectMapper.convertValue(user, UserResponseDTO.class);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);

        return objectMapper.convertValue(user.get(), UserResponseDTO.class);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public UserResponseDTO findByUsernameReturnToken(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(
                    () -> new UsernameNotFoundException(String.format(Message.USERNAME_NOT_FOUND, username))
                );
        
        return objectMapper.convertValue(user, UserResponseDTO.class);
    }

    @Override
    public boolean deleteUser(Long id_user) {
        if (userRepository.findById(id_user).isPresent()) {
            userRepository.deleteById(id_user);
            return true;
        }
        return false;
    }

    @Override
    public UserResponseDTO findUserById(Long id_user) {
        Optional<User> user = userRepository.findById(id_user);
        if (user.isEmpty()) {
            throw new NotFoundException(String.format(Message.USER_NOT_FOUND, id_user));
        }
        return objectMapper.convertValue(user.get(), UserResponseDTO.class);
    }
}
