package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.response.AuthResponseDTO;
import com.proyecto.proyecto.model.AuthResponse;

@Mapper
public interface AuthResponseMapper {

    AuthResponseMapper INSTANCE = Mappers.getMapper(AuthResponseMapper.class);

    @Mapping(target = "tokenDTO", source = "token")
    AuthResponseDTO authResponseToAuthResponseDTO(AuthResponse authResponse);

}
