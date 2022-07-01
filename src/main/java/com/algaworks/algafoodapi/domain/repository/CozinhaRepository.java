package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNome(String nome); // Poderia escrever qualquer coisa entre o find e o By. Usei Todas só para diferenciar

    // List<Cozinha> nome(String nome); // Também funciona, da mesma forma que o de cima.

    Optional<Cozinha> findByNome(String nome);

}
