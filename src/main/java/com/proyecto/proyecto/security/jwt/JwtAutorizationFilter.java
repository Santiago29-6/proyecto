package com.proyecto.proyecto.security.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAutorizationFilter extends OncePerRequestFilter{

    private final JwtProviderImpl jwtProviderImpl;

    public JwtAutorizationFilter (JwtProviderImpl jwtProviderImpl) {
        this.jwtProviderImpl = jwtProviderImpl;
    }

    public JwtAutorizationFilter () {
        this.jwtProviderImpl = new JwtProviderImpl();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException{
        Authentication authentication = jwtProviderImpl.getAuthentication(request);
        if(authentication != null && jwtProviderImpl.isTokenValid(request)){
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }

}
