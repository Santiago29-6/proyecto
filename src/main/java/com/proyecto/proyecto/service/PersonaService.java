package com.proyecto.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Persona;

@Service
public interface PersonaService {
    List<Persona> findAllPersonas();

    void deletePersona(Persona entity);

    void deletePersonaById(Long id_persona);

    Persona savePersona(Persona entity);
}
