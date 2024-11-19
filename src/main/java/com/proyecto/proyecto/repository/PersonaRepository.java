package com.proyecto.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.proyecto.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
    
}
