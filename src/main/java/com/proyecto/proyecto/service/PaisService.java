package com.proyecto.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Pais;

@Service
public interface PaisService {
    List<Pais> findAllPais();
}
