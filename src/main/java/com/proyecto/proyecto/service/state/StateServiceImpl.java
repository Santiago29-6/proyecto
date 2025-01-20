package com.proyecto.proyecto.service.state;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.State;
import com.proyecto.proyecto.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService{

    private final StateRepository stateRepository;

    public StateServiceImpl (StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAllStateOfPais(Long paisId){
        List<State> responseStates = new ArrayList<>();
        List<State> estados = stateRepository.findAll();
        for(int i = 0; i < estados.size(); i++){
            if(estados.get(i).getPais().getId().equals(paisId)){
                responseStates.add(estados.get(i));
            }
        }
        return responseStates;
    }

}
