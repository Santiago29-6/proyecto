package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.enums.*;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.security.UserPrincipal;
import com.proyecto.proyecto.service.user.UserServiceImpl;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class UserController {
    
    private final UserServiceImpl userServiceImpl;

    public UserController (UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/user/me")
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(userServiceImpl.findByUsernameReturnToken(userPrincipal.getUsername()), HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userServiceImpl.findAllUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User savedUser = userServiceImpl.saveUser(user);
        HttpStatus status = (user.getId() == null) ? HttpStatus.CREATED : HttpStatus.OK;
        return ResponseEntity.status(status).body(savedUser);
    }

    @PutMapping("/user/change/{role}")
    public ResponseEntity<Boolean> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,
            @PathVariable Role role) {
        userServiceImpl.changeRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }    
    
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id_user){
        return ResponseEntity.ok(userServiceImpl.deleteUser(id_user));
    }
}