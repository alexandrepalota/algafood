package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.exception.EntidadeRelacionadaNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoService estadoService;

    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    public Cidade buscar(Long id) {
        Cidade cidade = cidadeRepository.porId(id);
        if (cidade != null) {
            return cidade;
        }
        throw new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de cidade com código %d", id)
        );
    }

    public Cidade salvar(Cidade cidade) {
        try {
            Estado estado = estadoService.buscar(cidade.getEstado().getId());
            cidade.setEstado(estado);
            return cidadeRepository.salvar(cidade);
        } catch (EntidadeNaoEncontradaException e) {
            throw new EntidadeRelacionadaNaoEncontradaException(e.getMessage());
        }
    }

    public void excluir(Long id) {
        try {
            cidadeRepository.remover(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", id)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", id)
            );
        }
    }
}
