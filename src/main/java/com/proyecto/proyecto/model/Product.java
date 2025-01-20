package com.proyecto.proyecto.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

import com.proyecto.proyecto.model.enums.State;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", nullable =  false)
    private String name;

    @Column(name = "description", length = 400, nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "url_image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "id_brand")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @Column(name = "registration_date", nullable = false, updatable = false)
    private LocalDateTime registrationDate;

    @Column(name = "last_updated", nullable = false)
    private LocalDateTime lastUpdate;  

    @PrePersist
    protected void onCreate() {
        registrationDate = LocalDateTime.now();
        lastUpdate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastUpdate = LocalDateTime.now();
    }
}
