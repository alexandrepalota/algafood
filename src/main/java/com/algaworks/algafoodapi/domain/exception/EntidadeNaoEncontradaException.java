package com.algaworks.algafoodapi.domain.exception;

public abstract class EntidadeNaoEncontradaException extends NegocioException {

    public EntidadeNaoEncontradaException(String msg) {
        super(msg);
    }
}
