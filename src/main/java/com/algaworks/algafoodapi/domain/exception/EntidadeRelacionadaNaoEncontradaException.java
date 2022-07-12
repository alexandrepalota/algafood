package com.algaworks.algafoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EntidadeRelacionadaNaoEncontradaException extends RuntimeException {

    public EntidadeRelacionadaNaoEncontradaException(String msg) {
        super(msg);
    }

}
