package com.proyecto.proyecto.dto.response;

import com.proyecto.proyecto.enums.State;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductResponseDTO {

    private Long idDTO;

    private String nameDTO;

    private String descriptionDTO;

    private Long priceDTO;

    private Integer quantityDTO;

    private String skuDTO;

    private State stateDTO;

    private String imageDTO;

    private BrandResponseDTO brandDTO;

    private CategoryResponseDTO categoryDTO;

}
