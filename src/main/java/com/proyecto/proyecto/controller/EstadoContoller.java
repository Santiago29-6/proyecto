package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Estado;
import com.proyecto.proyecto.service.EstadoServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/estado/")
public class EstadoContoller {

    @Autowired
    private EstadoServiceImpl estadoServiceImpl;

    @GetMapping("{id}")
    public ResponseEntity<List<Estado>> getAllEstadoByPais(@PathVariable("id") Long idPais) {
        return ResponseEntity.ok(estadoServiceImpl.findAllEstadoOfPais(idPais));
    }
    
}
