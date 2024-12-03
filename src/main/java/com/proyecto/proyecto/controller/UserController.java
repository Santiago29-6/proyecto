package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Role;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.security.UserPrincipal;
import com.proyecto.proyecto.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user){
        if(userService.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }

    @PutMapping("change/{role}")
    public ResponseEntity<Boolean> changeRole(@AuthenticationPrincipal UserPrincipal userPrincipal,
            @PathVariable Role role) {
        userService.changeRole(role, userPrincipal.getUsername());
        return ResponseEntity.ok(true);
    }

    @GetMapping
    public ResponseEntity<User> getCurrentUser(@AuthenticationPrincipal UserPrincipal userPrincipal){
        return new ResponseEntity<>(userService.findByUsernameReturnToken(userPrincipal.getUsername()), HttpStatus.OK);
    }

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.ok(userService.findAllUsers());
    }
    
}