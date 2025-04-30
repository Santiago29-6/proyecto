package com.proyecto.proyecto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.proyecto.proyecto.dto.request.ProductRequestDTO;
import com.proyecto.proyecto.dto.response.ProductResponseDTO;
import com.proyecto.proyecto.model.Product;

@Mapper(uses = {BrandMapper.class, CategoryMapper.class})
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", ignore = true)
    @Mapping(target = "lastUpdate", ignore = true)
    @Mapping(target = "name", source = "nameDTO")
    @Mapping(target = "description", source = "descriptionDTO")
    @Mapping(target = "price", source = "priceDTO")
    @Mapping(target = "quantity", source = "quantityDTO")
    @Mapping(target = "sku", source = "skuDTO")
    @Mapping(target = "state", source = "stateDTO")
    @Mapping(target = "image", source = "imageDTO")
    @Mapping(target = "brand", source = "brandDTO")
    @Mapping(target = "category", source = "categoryDTO")
    Product productRequestDTOToProduct(ProductRequestDTO product);

    @Mapping(target = "idDTO", source = "id")
    @Mapping(target = "nameDTO", source = "name")
    @Mapping(target = "descriptionDTO", source = "description")
    @Mapping(target = "priceDTO", source = "price")
    @Mapping(target = "quantityDTO", source = "quantity")
    @Mapping(target = "skuDTO", source = "sku")
    @Mapping(target = "stateDTO", source = "state")
    @Mapping(target = "imageDTO", source = "image")
    @Mapping(target = "brandDTO", expression = "java(BrandMapper.INSTANCE.brandToBrandResponseDTO(product.getBrand()))")
    @Mapping(target = "categoryDTO", expression = "java(CategoryMapper.INSTANCE.categoryToCategoryResponseDTO(product.getCategory()))")
    ProductResponseDTO productToProductResponseDTO(Product product);

}
