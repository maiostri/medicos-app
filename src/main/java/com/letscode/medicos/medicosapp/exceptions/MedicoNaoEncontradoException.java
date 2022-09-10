package com.letscode.medicos.medicosapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;


public class MedicoNaoEncontradoException extends ResponseStatusException {

    public MedicoNaoEncontradoException() {
        super(HttpStatus.NOT_FOUND);
    }
}
