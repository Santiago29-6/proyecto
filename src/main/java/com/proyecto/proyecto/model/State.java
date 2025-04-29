package com.proyecto.proyecto.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estado")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Country country;
    

}
