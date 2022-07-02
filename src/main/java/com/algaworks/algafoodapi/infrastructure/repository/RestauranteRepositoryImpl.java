package com.algaworks.algafoodapi.infrastructure.repository;

// o sufixo Impl no nome da classe é importante, pois é assim que o Spring entende que é uma
// implementação customizada da interface RestauranteRepository, já que a classe não usa o
// implements.

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

        var parametros = new HashMap<String, Object>();

        var jpql = new StringBuilder();
        jpql.append("from Restaurante where 0 = 0 ");

        if (StringUtils.hasLength(nome)) {
            jpql.append("and nome like :nome ");
            parametros.put("nome", "%" + nome + "%");
        }
        if (taxaFreteInicial != null) {
            jpql.append("and taxaFrete >= :taxaInicial ");
            parametros.put("taxaInicial", taxaFreteInicial);
        }
        if (taxaFreteFinal != null) {
            jpql.append("and taxaFrete <= :taxaFinal");
            parametros.put("taxaFinal", taxaFreteFinal);
        }

        var query = entityManager.createQuery(jpql.toString(), Restaurante.class);
        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
        return query.getResultList();
    }
}
