package com.proyecto.proyecto.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String nombre;
    private String apellido;

    @Enumerated(EnumType.STRING)
    private Role role;

    private LocalDateTime fechaRegistro;

    @Transient
    private String token;

}
