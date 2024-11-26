package com.proyecto.proyecto.service;

import com.proyecto.proyecto.model.AuthRequest;

public interface AuthenticationService {

    String signInAndReturnJwt(AuthRequest signInRequest);

}
