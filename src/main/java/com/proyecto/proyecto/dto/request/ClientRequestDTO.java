package com.proyecto.proyecto.dto.request;

import com.proyecto.proyecto.dto.response.CountryResponseDTO;
import com.proyecto.proyecto.dto.response.StateResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientRequestDTO {

    private String nameDTO;

    private String lastNameDTO;

    private Integer ageDTO;

    private CountryResponseDTO countryDTO;

    private StateResponseDTO stateDTO;

}
