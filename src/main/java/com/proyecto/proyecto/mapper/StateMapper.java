package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.StateRequestDTO;
import com.proyecto.proyecto.dto.response.StateResponseDTO;
import com.proyecto.proyecto.model.State;

@Mapper(uses = {CountryMapper.class})
public interface StateMapper {

    StateMapper INSTANCE = Mappers.getMapper(StateMapper.class);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    @Mapping(target = "countryDTO", source = "country")
    StateResponseDTO stateToStateResponseDTO(State state);

    @Mapping(target = "id", source = "idDTO")
    @Mapping(target = "name", ignore = true)
    @Mapping(target = "country", ignore = true)
    State stateResponseDTOToState(StateRequestDTO requestDTO);

}
