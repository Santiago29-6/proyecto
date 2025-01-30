package com.proyecto.proyecto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.dto.request.AuthRequestDTO;
import com.proyecto.proyecto.dto.request.UserRequestDTO;
import com.proyecto.proyecto.dto.response.AuthResponseDTO;
import com.proyecto.proyecto.dto.response.UserResponseDTO;
import com.proyecto.proyecto.service.authentication.AuthenticationServiceImpl;
import com.proyecto.proyecto.service.user.UserServiceImpl;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")
public class AuthenticationController {

    private final AuthenticationServiceImpl authenticationServiceImpl;

    private final UserServiceImpl userServiceImpl;

    public AuthenticationController (AuthenticationServiceImpl authenticationServiceImpl, UserServiceImpl userServiceImpl) {
        this.authenticationServiceImpl = authenticationServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/authentication/sign-up")
    public ResponseEntity<UserResponseDTO> signUp(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userServiceImpl.saveUser(userRequestDTO), HttpStatus.CREATED);
    }

    @PostMapping("/authentication/sign-in")
    public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthRequestDTO authRequestDTO) {
        return new ResponseEntity<>(authenticationServiceImpl.signInAndReturnJwt(authRequestDTO), HttpStatus.OK);
    }
}
