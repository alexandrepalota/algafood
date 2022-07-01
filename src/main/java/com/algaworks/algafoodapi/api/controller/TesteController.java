package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/testes")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam String nome) {
        return cozinhaRepository.findTodasByNomeContainingIgnoreCase(nome);
    }

    @GetMapping("/cozinhas/unica-por-nome")
    public Cozinha cozinhaPorNome(@RequestParam String nome) {
        return cozinhaRepository.findByNome(nome).orElse(null);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> porTaxaFrete(BigDecimal min, BigDecimal max) {
        return restauranteRepository.findAllByTaxaFreteBetween(min, max);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> porNome(String nome, Long cozinhaId) {
        return restauranteRepository.findAllByNomeContainingIgnoreCaseAndCozinhaId(nome, cozinhaId);
    }
}
