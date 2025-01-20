package com.proyecto.proyecto.service.country;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyecto.proyecto.model.Country;
import com.proyecto.proyecto.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

    private final CountryRepository countryRepository;

    public CountryServiceImpl (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAllCountries(){
        return countryRepository.findAll();
    }

}
