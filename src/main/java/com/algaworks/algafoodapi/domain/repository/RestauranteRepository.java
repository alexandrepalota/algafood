package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

    List<Restaurante> findAllByTaxaFreteBetween(BigDecimal min, BigDecimal max);

    List<Restaurante> findAllByNomeContainingIgnoreCaseAndCozinhaId(String nome, Long cozinhaId);
}
