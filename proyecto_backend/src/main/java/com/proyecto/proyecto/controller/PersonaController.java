package com.proyecto.proyecto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Persona;
import com.proyecto.proyecto.service.PersonaServiceImpl;

@RestController
@RequestMapping("/personas/")
public class PersonaController {

    private PersonaServiceImpl personaServiceImpl;

    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas(){
        return ResponseEntity.ok(personaServiceImpl.findAllPersonas());
    }

    @PostMapping
    public ResponseEntity<Persona> savePersona (@RequestBody Persona persona){
        try {
            Persona personaGuardada = personaServiceImpl.savePersona(persona);
            return ResponseEntity.created(new URI("/personas/"+personaGuardada.getId())).body(personaGuardada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }

}
