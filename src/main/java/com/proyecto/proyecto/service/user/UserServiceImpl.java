package com.proyecto.proyecto.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.enums.*;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.repository.UserRepository;
import com.proyecto.proyecto.security.jwt.JwtProviderImpl;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtProviderImpl jwtProviderImpl;

    public UserServiceImpl (UserRepository userRepository, PasswordEncoder passwordEncoder, JwtProviderImpl jwtProviderImpl) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtProviderImpl = jwtProviderImpl;
    }

    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        User userCreated = userRepository.save(user);

        String jwt = jwtProviderImpl.generateToken(userCreated);
        userCreated.setToken(jwt);
        
        return userCreated;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Transactional
    @Override
    public void changeRole(Role newRole, String username) {
        userRepository.updateUserRole(username, newRole);
    }

    @Override
    public User findByUsernameReturnToken(String username){
        User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe: " + username));
        
        String jwt = jwtProviderImpl.generateToken(user);
        user.setToken(jwt);
        return user;
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
}
