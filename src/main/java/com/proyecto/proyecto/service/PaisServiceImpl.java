package com.proyecto.proyecto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Pais;
import com.proyecto.proyecto.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisService{
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAllPais(){
        return paisRepository.findAll();
    }

}
