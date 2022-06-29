package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<Restaurante> listar() {
        return restauranteRepository.listar();
    }

    public Restaurante bucar(Long id) {
        Restaurante restaurante = restauranteRepository.porId(id);
        if (restaurante != null) return restaurante;
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de restaurante com código %d", id)
        );
    }
}
