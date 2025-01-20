package com.proyecto.proyecto.service.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.AuthRequest;
import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.security.UserPrincipal;
import com.proyecto.proyecto.security.jwt.JwtProvider;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationManager authenticationManager;

    private final JwtProvider jwtProvider;

    public AuthenticationServiceImpl (AuthenticationManager authenticationManager, JwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    @Override
    public String signInAndReturnJwt(AuthRequest signInRequest){
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrincipal);

        User singInUser = userPrincipal.getUser();
        singInUser.setToken(jwt);

        return jwt;
    } 
}
