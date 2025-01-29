package com.proyecto.proyecto.dto.request;

import com.proyecto.proyecto.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequestDTO {

    private Long idDTO;
    
    private String usernameDTO;

    private String passwordDTO;

    private String nameDTO;

    private String lastNameDTO;

    private Role roleDTO;

}
