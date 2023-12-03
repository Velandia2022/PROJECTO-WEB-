package com.IFSULDEMINAS.SistemaDeGerenciamiento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AdotanteNotFoundException extends RuntimeException {

    public AdotanteNotFoundException(String mensaje) {
        super(mensaje);
    }
}

