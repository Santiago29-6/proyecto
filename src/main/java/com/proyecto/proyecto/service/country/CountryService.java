package com.proyecto.proyecto.service.country;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Country;

@Service
public interface CountryService {
    List<Country> findAllCountries();
}
