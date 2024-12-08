package com.proyecto.proyecto.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "registrationDate", nullable = false)
    private LocalDateTime registrationDate;

    @Column(name = "lastUpdated", nullable = false)
    private LocalDateTime lastUpdated;

    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDateTime.now();
        lastUpdated = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdated = LocalDateTime.now();
    }
}
