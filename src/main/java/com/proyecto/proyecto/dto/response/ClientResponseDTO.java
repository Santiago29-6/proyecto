package com.proyecto.proyecto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientResponseDTO {

    private Long idDTO;

    private String nameDTO;

    private String lastNameDTO;

    private Integer ageDTO;

    private CountryResponseDTO countryDTO;

    private StateResponseDTO stateDTO;
    
}
