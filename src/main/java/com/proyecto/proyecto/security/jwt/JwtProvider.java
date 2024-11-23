package com.proyecto.proyecto.security.jwt;

import org.springframework.security.core.Authentication;

import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.security.UserPrincipal;

import jakarta.servlet.http.HttpServletRequest;

public interface JwtProvider {

    String generateToken(UserPrincipal auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
    
    String generateToken(User user);

}
