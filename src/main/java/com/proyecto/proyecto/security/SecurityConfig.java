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

import com.proyecto.proyecto.model.Role;
import com.proyecto.proyecto.security.jwt.JwtAutorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
                .requestMatchers("/authentication/sign-in", "/authentication/sign-up").permitAll()
                .requestMatchers(HttpMethod.GET, "/personas/").authenticated()
                .requestMatchers(HttpMethod.POST, "/personas/**").hasRole(Role.ADMIN.name())
                .requestMatchers("/user/**").authenticated()
                .requestMatchers(HttpMethod.GET,"/category/").authenticated()
                .requestMatchers(HttpMethod.POST,"/category/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET,"/brand/").authenticated()
                .requestMatchers(HttpMethod.POST,"/brand/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.GET,"/product/").authenticated()
                .requestMatchers(HttpMethod.POST,"/product/**").hasRole(Role.ADMIN.name())
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
