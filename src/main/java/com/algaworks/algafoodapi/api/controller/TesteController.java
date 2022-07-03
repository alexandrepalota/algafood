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

import static com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

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

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> find(String nome, BigDecimal min, BigDecimal max) {
        return restauranteRepository.find(nome, min, max);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> porNome(String nome, Long cozinhaId) {
        return restauranteRepository.consultarPorNomeECozinha(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Restaurante primeiroPorNome(String nome) {
        return restauranteRepository.findFirstByNomeContaining(nome).orElse(null);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> top2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {
        return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
