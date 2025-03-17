package com.proyecto.proyecto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StateResponseDTO {

    private Long idDTO;
    
    private String nameDTO;

    private CountryResponseDTO countryDTO;
    
}
