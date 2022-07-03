package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
        JpaSpecificationExecutor<Restaurante> {

    List<Restaurante> findAllByTaxaFreteBetween(BigDecimal min, BigDecimal max);

    List<Restaurante> findAllByNomeContainingIgnoreCaseAndCozinhaId(String nome, Long cozinhaId);

    List<Restaurante> consultarPorNomeECozinha(String nome, @Param("id") Long cozinhaId);

    Optional<Restaurante> findFirstByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    boolean existsByNome(String nome);

    int countByCozinhaId(Long id);

}
