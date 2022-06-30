package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
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
        return restauranteRepository.findAll();
    }

    public Restaurante bucar(Long id) {
        return restauranteRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de restaurante com código %d", id)
        ));
    }

    public Restaurante salvar(Restaurante restaurante) {
        try {
            Cozinha cozinha = cozinhaService.buscar(restaurante.getCozinha().getId());
            restaurante.setCozinha(cozinha);
            return restauranteRepository.save(restaurante);
        } catch (EntidadeNaoEncontradaException e) {
            throw new EntidadeRelacionadaNaoEncontradaException(e.getMessage());
        }
    }
}
