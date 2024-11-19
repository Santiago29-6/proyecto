package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Pais;
import com.proyecto.proyecto.service.PaisServiceImpl;

@RestController
@RequestMapping("/pais/")
public class PaisController {

    @Autowired
    private PaisServiceImpl paisServiceImp;

    @GetMapping
    public ResponseEntity<List<Pais>> getAllPaises(){
        return ResponseEntity.ok(paisServiceImp.findAllPais());
    }
}
