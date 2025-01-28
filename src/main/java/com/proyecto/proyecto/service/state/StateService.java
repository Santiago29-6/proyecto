package com.proyecto.proyecto.service.state;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.State;

@Service
public interface StateService{

	List<State> findAllStateOfCountry(Long paisId);
	
}