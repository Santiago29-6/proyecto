package com.proyecto.proyecto.dto.request;

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

    private CountryRequestDTO countryDTO;

    private StateRequestDTO stateDTO;

}
