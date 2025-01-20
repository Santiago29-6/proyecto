package com.proyecto.proyecto.service.authentication;

import com.proyecto.proyecto.model.AuthRequest;

public interface AuthenticationService {

    String signInAndReturnJwt(AuthRequest signInRequest);

}
