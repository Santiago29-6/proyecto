package com.proyecto.proyecto.dto.response;

import com.proyecto.proyecto.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseDTO {

    private Long idDTO;

    private String usernameDTO;

    private String passwordDTO;

    private String nameDTO;

    private String lastNameDTO;

    private Role roleDTO;

}
