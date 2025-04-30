package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.BrandRequestDTO;
import com.proyecto.proyecto.dto.response.BrandResponseDTO;
import com.proyecto.proyecto.model.Brand;

@Mapper
public interface BrandMapper {

    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "name", source = "nameDTO")
    Brand brandRequestToBrand(BrandRequestDTO brandRequestDTO);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    BrandResponseDTO brandToBrandResponseDTO(Brand brand);

}
