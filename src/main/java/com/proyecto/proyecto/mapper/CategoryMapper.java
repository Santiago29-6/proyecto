package com.proyecto.proyecto.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.CategoryRequestDTO;
import com.proyecto.proyecto.dto.response.CategoryResponseDTO;
import com.proyecto.proyecto.model.Category;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "name", source = "nameDTO")
    Category categoryRequestDTOToCategory(CategoryRequestDTO categoryRequestDTO);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    CategoryResponseDTO categoryToCategoryResponseDTO(Category category);

}
