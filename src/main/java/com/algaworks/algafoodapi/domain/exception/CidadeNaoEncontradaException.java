package com.algaworks.algafoodapi.domain.exception;

public class CidadeNaoEncontradaException extends EntidadeNaoEncontradaException {

    public CidadeNaoEncontradaException(String msg) {
        super(msg);
    }

    public CidadeNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de cidade com código %d", id));
    }
}
