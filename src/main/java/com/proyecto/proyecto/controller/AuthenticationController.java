package com.proyecto.proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.AuthRequest;
import com.proyecto.proyecto.model.AuthResponse;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.service.authentication.AuthenticationServiceImpl;
import com.proyecto.proyecto.service.user.UserServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("authentication")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;

    private final UserServiceImpl userServiceImpl;

    public AuthenticationController (AuthenticationServiceImpl authenticationServiceImpl, UserServiceImpl userServiceImpl) {
        this.authenticationServiceImpl = authenticationServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        if(userServiceImpl.findByUsername(user.getUsername()).isPresent()){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(userServiceImpl.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signIn(@RequestBody AuthRequest authRequest) {
        String token = authenticationServiceImpl.signInAndReturnJwt(authRequest);
        return new ResponseEntity<>(new AuthResponse(token), HttpStatus.OK);
    }
}
