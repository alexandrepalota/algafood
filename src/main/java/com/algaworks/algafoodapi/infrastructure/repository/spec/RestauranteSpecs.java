package com.algaworks.algafoodapi.infrastructure.repository.spec;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

public class RestauranteSpecs {

    public static Specification<Restaurante> comFreteGratis() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("taxaFrete"), BigDecimal.ZERO); // Implementando a interface com lambda
    }

    public static Specification<Restaurante> comNomeSemelhante(String nome) {
        return (root, query, criteriaBuilder) ->
                !StringUtils.hasText(nome) ? criteriaBuilder.conjunction() : // isso torna o nome opcional. não faz nenhuma operação sql
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}
