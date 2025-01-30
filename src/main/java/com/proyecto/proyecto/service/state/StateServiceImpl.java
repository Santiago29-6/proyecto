package com.proyecto.proyecto.service.state;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.State;
import com.proyecto.proyecto.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService {

    private final StateRepository stateRepository;

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAllStateOfCountry(Long id_country) {
        List<State> state = stateRepository.findAll();

        return state.stream()
                .filter(s -> s.getPais().getId().equals(id_country))
                .collect(Collectors.toList());
    }

}
