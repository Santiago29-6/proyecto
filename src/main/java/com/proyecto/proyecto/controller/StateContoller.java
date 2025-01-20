package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.State;
import com.proyecto.proyecto.service.state.StateServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api")
public class StateContoller {

    private final StateServiceImpl stateServiceImpl;

    public StateContoller(StateServiceImpl stateServiceImpl){
        this.stateServiceImpl = stateServiceImpl;
    }

    @GetMapping("/state/{id}")
    public ResponseEntity<List<State>> getAllEstadoByPais(@PathVariable("id") Long idPais) {
        return ResponseEntity.ok(stateServiceImpl.findAllStateOfPais(idPais));
    }
    
}
