package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.AuthRequestDTO;
import com.proyecto.proyecto.model.AuthRequest;

@Mapper
public interface AuthRequestMapper {

    AuthRequestMapper INSTANCE = Mappers.getMapper(AuthRequestMapper.class);

    @Mapping(target = "username", source = "usernameDTO")
    @Mapping(target = "password", source = "passwordDTO")
    AuthRequest authRequestDTOToAuthRequest(AuthRequestDTO authRequestDTO);

}
