package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.ClientRequestDTO;
import com.proyecto.proyecto.dto.response.ClientResponseDTO;
import com.proyecto.proyecto.model.Client;

@Mapper(uses = {CountryMapper.class, StateMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", source = "idDTO")
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "lastName", source = "lastNameDTO")
    @Mapping(target = "age", source = "ageDTO")
    @Mapping(target = "country", source = "countryDTO")
    @Mapping(target = "state", source = "stateDTO")
    Client clientRequestDTOToClient(ClientRequestDTO client);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    @Mapping(target = "lastNameDTO", source = "lastName")
    @Mapping(target = "ageDTO", source = "age")
    @Mapping(target = "countryDTO", source = "country")
    @Mapping(target = "stateDTO", source = "state")
    ClientResponseDTO clientToClientResponseDTO(Client client); 
    


}
