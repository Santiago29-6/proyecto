package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.CountryRequestDTO;
import com.proyecto.proyecto.dto.response.CountryResponseDTO;
import com.proyecto.proyecto.model.Country;

public interface CountryMapper {

    CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    CountryResponseDTO countryToCountryResponseDTO(Country country);

    @Mapping(target = "id", source = "idDTO")
    @Mapping(target = "name", ignore = true)
    Country countryRequestDTOToCountry(CountryRequestDTO countryRequestDTO);

}
