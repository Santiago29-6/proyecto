package com.proyecto.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Persona;
import com.proyecto.proyecto.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<Persona> findAllPersonas(){
        return personaRepository.findAll();
    }

    @Override
    public void deletePersona(Persona entity){
        personaRepository.delete(entity);
    }

    @Override
    public void deletePersonaById(Long id_persona){
        personaRepository.deleteById(id_persona);
    }

    @Override
    public Persona savePersona(Persona entity){
        return personaRepository.save(entity);
    }
    @Override
    public Optional<Persona> findPersonaById(Long id_persona){
        return personaRepository.findById(id_persona);
    }
}
