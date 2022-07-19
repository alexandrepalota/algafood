package com.algaworks.algafoodapi.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException {

    public CozinhaNaoEncontradaException(String msg) {
        super(msg);
    }

    public CozinhaNaoEncontradaException(Long id) {
        this(String.format("Não existe um cadastro de cozinha com código %d", id));
    }
}
