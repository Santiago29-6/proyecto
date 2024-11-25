package com.proyecto.proyecto.service;

import com.proyecto.proyecto.model.User;

public interface AuthenticationService {

    User signInAndReturnJwt(User signInRequest);

}
