package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.UserRequestDTO;
import com.proyecto.proyecto.dto.response.UserResponseDTO;
import com.proyecto.proyecto.model.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "id", source = "idDTO")
    @Mapping(target = "username", source = "usernameDTO")
    @Mapping(target = "password", source ="passwordDTO")
    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "lastName", source = "lastNameDTO")
    @Mapping(target = "role", source = "roleDTO")
    User userRequestToUser(UserRequestDTO userRequestDTO);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    @Mapping(target = "lastNameDTO", source = "lastName")
    @Mapping(target = "usernameDTO", source = "username")
    @Mapping(target = "passwordDTO", source = "password")
    @Mapping(target = "roleDTO", source = "role")
    UserResponseDTO userToUserResponseDTO(User user);
    
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "id", source = "idDTO")
    @Mapping(target = "username", source = "usernameDTO")
    @Mapping(target = "password", source ="passwordDTO")
    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "lastName", source = "lastNameDTO")
    @Mapping(target = "role", source = "roleDTO")
    User userResponseToUser(UserResponseDTO userRequestDTO);
}
