package com.proyecto.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Persona;

@Service
public interface PersonaService {
    List<Persona> findAllPersonas();

    void deletePersona(Persona entity);

    void deletePersonaById(Long id_persona);

    Persona savePersona(Persona entity);

    Optional <Persona> findPersonaById(Long id_persona);

    Page<Persona> findAll(Pageable pageable);

    List<Persona> findAll(Sort sort);
}
