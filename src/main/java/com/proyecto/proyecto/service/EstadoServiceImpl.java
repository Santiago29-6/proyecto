package com.proyecto.proyecto.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Estado;
import com.proyecto.proyecto.repository.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAllEstadoOfPais(Long paisId){
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estados = estadoRepository.findAll();
        for(int i = 0; i < estados.size(); i++){
            if(estados.get(i).getPais().getId().equals(paisId)){
                estadosRespuesta.add(estados.get(i));
            }
        }
        return estadosRespuesta;
    }

}
