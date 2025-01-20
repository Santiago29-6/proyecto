package com.proyecto.proyecto.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.proyecto.model.Country;
import com.proyecto.proyecto.service.country.CountryServiceImpl;

@RestController
@RequestMapping("/api")
public class CountryController {

    private final CountryServiceImpl countryServiceImpl;

    public CountryController (CountryServiceImpl countryServiceImpl) {
        this.countryServiceImpl = countryServiceImpl;
    }

    @GetMapping("/country")
    public ResponseEntity<List<Country>> getAllPaises(){
        return ResponseEntity.ok(countryServiceImpl.findAllCountries());
    }
}
