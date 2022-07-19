package com.algaworks.algafoodapi.domain.exception;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

    public EstadoNaoEncontradoException(String msg) {
        super(msg);
    }

    public EstadoNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de estado com código %d", id));
    }
}
