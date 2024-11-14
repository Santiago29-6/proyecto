package com.proyecto.proyecto.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Estado;


@Service
public interface EstadoService{
	List<Estado> findAllEstadoOfPais(Long paisId);
}