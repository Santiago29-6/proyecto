package com.proyecto.proyecto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.proyecto.proyecto.enums.*;
import com.proyecto.proyecto.security.jwt.JwtAutorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomUserDetailService customUserDetailService;

    private final PasswordEncoder passwordEncoder;

    public SecurityConfig (CustomUserDetailService customUserDetailService, PasswordEncoder passwordEncoder) {
        this.customUserDetailService = customUserDetailService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
        throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth)
        throws Exception{
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
        throws Exception{
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);

        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);

        AuthenticationManager authenticationManager = auth.build();

        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authenticationManager(authenticationManager)
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authz -> authz
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers("/api/authentication/sign-in", "/api/authentication/sign-up").permitAll()
                .requestMatchers(HttpMethod.GET, "/api/client/").authenticated()
                .requestMatchers(HttpMethod.POST, "/api/client/**").hasRole(Role.ADMIN.name())
                .requestMatchers("/api/user/**").authenticated()
                .requestMatchers(HttpMethod.GET,"/api/category/").authenticated()
                .requestMatchers(HttpMethod.POST,"/api/category/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET,"/api/brand/").authenticated()
                .requestMatchers(HttpMethod.POST,"/api/brand/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET,"/api/product/").authenticated()
                .requestMatchers(HttpMethod.POST,"/api/product/**").hasRole(Role.ADMIN.name())
                .anyRequest().permitAll()
            )
            .addFilterBefore(jwtAutorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }

    @Bean
    public JwtAutorizationFilter jwtAutorizationFilter() {
        return new JwtAutorizationFilter();
    }
}
