package com.proyecto.proyecto.service.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.proyecto.dto.request.AuthRequestDTO;
import com.proyecto.proyecto.dto.response.AuthResponseDTO;
import com.proyecto.proyecto.model.AuthRequest;
import com.proyecto.proyecto.model.AuthResponse;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.security.UserPrincipal;
import com.proyecto.proyecto.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    private final ObjectMapper objectMapper;

    public AuthenticationServiceImpl (AuthenticationManager authenticationManager, JwtProvider jwtProvider, ObjectMapper objectMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.objectMapper = objectMapper;
    }

    @Override
    public AuthResponseDTO signInAndReturnJwt(AuthRequestDTO authRequestDTO){
        AuthRequest authRequest = objectMapper.convertValue(authRequestDTO, AuthRequest.class);
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        AuthResponse authResponse = new AuthResponse(jwtProvider.generateToken(userPrincipal));

        User singInUser = userPrincipal.getUser();
        singInUser.setToken(authResponse.getToken());

        return objectMapper.convertValue(authResponse, AuthResponseDTO.class);
    } 
}
