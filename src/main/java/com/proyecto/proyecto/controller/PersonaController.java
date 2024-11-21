package com.proyecto.proyecto.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.proyecto.proyecto.model.Persona;
import com.proyecto.proyecto.service.PersonaServiceImpl;

@RestController
@RequestMapping("/personas/")
public class PersonaController {

    @Autowired
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

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Boolean> deletePersona(@PathVariable("id") Long id_persona){
        personaServiceImpl.deletePersonaById(id_persona);
        return ResponseEntity.ok(!(personaServiceImpl.findPersonaById(id_persona) != null));
    }

}
