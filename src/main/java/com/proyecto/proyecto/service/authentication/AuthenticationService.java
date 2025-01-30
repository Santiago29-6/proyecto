package com.proyecto.proyecto.service.authentication;

import com.proyecto.proyecto.dto.request.AuthRequestDTO;
import com.proyecto.proyecto.dto.response.AuthResponseDTO;

public interface AuthenticationService {

    AuthResponseDTO signInAndReturnJwt(AuthRequestDTO authRequestDTO);

}
