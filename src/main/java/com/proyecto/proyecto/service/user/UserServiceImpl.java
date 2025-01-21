package com.proyecto.proyecto.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.enums.*;
import com.proyecto.proyecto.exception.NotFoundException;
import com.proyecto.proyecto.exception.UsernameAlreadyExistsException;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.repository.UserRepository;
import com.proyecto.proyecto.security.jwt.JwtProviderImpl;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProviderImpl jwtProviderImpl;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder,
            JwtProviderImpl jwtProviderImpl) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProviderImpl = jwtProviderImpl;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {

        if (user.getId() != null) {
            findUserById(user.getId());
        } else {
            findByUsername(user.getUsername());
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            throw new UsernameAlreadyExistsException("El nombre de usuario ya está en uso: " + username);
        }
        return user;
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public User findByUsernameReturnToken(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con ese username no existe: " + username));

        String jwt = jwtProviderImpl.generateToken(user);
        user.setToken(jwt);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("No se ha encontrado un el id: " + id);
        }
        return user;
    }
}
