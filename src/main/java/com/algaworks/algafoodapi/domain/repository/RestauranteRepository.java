package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
        JpaSpecificationExecutor<Restaurante> {

    /*
     * Essa query é para resolver o problema do N+1
     * Ao fazer join em cozinha (que é ManyToOne) o jpa faz o fetch automaticamente.
     * Ao fazer join em formasPagamento apenas com join, não resolve o N+1 pois o jpa não faz fetch de ManyToMany
     * Para resolver isso, usa-se o join fetch. Mas como pode ser que um restaurante não tenha formas de pagamento,
     * ele não seria retornado na pesquisa. Então usou-se o left join fetch
     */
    @Query("from Restaurante r join r.cozinha left join fetch r.formasPagamento")
    List<Restaurante> findAll();

    List<Restaurante> findAllByTaxaFreteBetween(BigDecimal min, BigDecimal max);

    List<Restaurante> findAllByNomeContainingIgnoreCaseAndCozinhaId(String nome, Long cozinhaId);

    List<Restaurante> consultarPorNomeECozinha(String nome, @Param("id") Long cozinhaId);

    Optional<Restaurante> findFirstByNomeContaining(String nome);

    List<Restaurante> findTop2ByNomeContaining(String nome);

    boolean existsByNome(String nome);

    int countByCozinhaId(Long id);

}
