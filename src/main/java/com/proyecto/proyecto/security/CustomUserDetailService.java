package com.proyecto.proyecto.security;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.User;
import com.proyecto.proyecto.service.user.UserServiceImpl;
import com.proyecto.proyecto.util.SecurityUtils;

@Service
public class CustomUserDetailService implements UserDetailsService{

    private final UserServiceImpl userServiceImpl;

    public CustomUserDetailService (UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userServiceImpl.findByUsername(username)
        .orElseThrow( () ->new UsernameNotFoundException("El usuario no fue encontrado:" + username));

        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));

        return UserPrincipal.builder()
            .user(user)
            .id(user.getId())
            .username(username)
            .password(user.getPassword())
            .authorities(authorities)
            .build();
    }
}
