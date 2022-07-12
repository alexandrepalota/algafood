package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    public static final String NAO_ENCONTRADO = "Não existe um cadastro de estado com código %d";
    public static final String EM_USO = "Estado de código %d não pode ser removido, pois está em uso";
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    public Estado buscar(Long id) {
        return estadoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format(NAO_ENCONTRADO, id)
        ));
    }

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void excluir(Long id) {
        try {
            estadoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(String.format(NAO_ENCONTRADO, id));
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(String.format(EM_USO, id));
        }
    }

}
