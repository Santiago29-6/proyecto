package com.proyecto.proyecto.exception;

public class UsernameAlreadyExistsException extends RuntimeException {
    
    public UsernameAlreadyExistsException (String menssage) {
        super(menssage);
    }
}
