package com.algaworks.algafoodapi.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

    public RestauranteNaoEncontradoException(String msg) {
        super(msg);
    }

    public RestauranteNaoEncontradoException(Long id) {
        this(String.format("Não existe um cadastro de restaurante com código %d", id));
    }
}
