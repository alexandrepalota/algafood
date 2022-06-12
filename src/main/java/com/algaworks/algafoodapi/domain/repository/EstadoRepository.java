package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado porId(Long id);

    Estado adicionar(Estado estado);

    void remover(Estado estado);

}
