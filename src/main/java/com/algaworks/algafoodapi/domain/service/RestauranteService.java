package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaService cozinhaService;

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

    public Restaurante salvar(Restaurante restaurante) {
        Cozinha cozinha = cozinhaService.buscar(restaurante.getCozinha().getId());
        restaurante.setCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);
    }
}
