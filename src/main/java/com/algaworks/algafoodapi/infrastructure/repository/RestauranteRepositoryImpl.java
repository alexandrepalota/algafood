package com.algaworks.algafoodapi.infrastructure.repository;

// o sufixo Impl no nome da classe é importante, pois é assim que o Spring entende que é uma
// implementação customizada da interface RestauranteRepository, já que a classe não usa o
// implements.

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;

    /*
    Essa injeção foi feita para que o método findAll do JpaRepository pudesse ser utilizado, já que a interface
    RestauranteRepositoryQueries (implementada nesta classe) não possui esse método.
    Só que aí surgiu um problema: Ao injetar RestauranteRepository estourou uma exception de referência circular, pois
    RestauranteRepository extende RestauranteRepositoryQueries.
    Para evitar essa referência circular, foi necessário adicionar a anotação @Lazy.
     */
    @Autowired @Lazy
    private RestauranteRepository restauranteRepository;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        Root<Restaurante> root = criteria.from(Restaurante.class);

        var predicates = new ArrayList<Predicate>();
        if (StringUtils.hasText(nome)) predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
        if (taxaFreteInicial != null) predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
        if (taxaFreteFinal != null) predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
        criteria.where(predicates.toArray(new Predicate[0])); // esst toArray é pq o método recebe varArgs. no [0] poderia ser qqr valor

        TypedQuery<Restaurante> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public List<Restaurante> findComFreteGratis(String nome) {
        return restauranteRepository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }
}
