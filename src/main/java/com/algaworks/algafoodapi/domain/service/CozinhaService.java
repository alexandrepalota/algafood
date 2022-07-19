package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.CozinhaNaoEncontradaException;
import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CozinhaService {

    public static final String NAO_ENCONTRADA = "Não existe um cadastro de cozinha com código %d";
    public static final String EM_USO = "Cozinha de código %d não pode ser removida, pois está em uso";
    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha buscar(Long id) {
        return cozinhaRepository.findById(id).orElseThrow(() -> new CozinhaNaoEncontradaException(id));
    }

    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);
        } catch (EmptyResultDataAccessException e) {
            throw new CozinhaNaoEncontradaException(cozinhaId);
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(EM_USO, cozinhaId)
            );
        }
    }
}
