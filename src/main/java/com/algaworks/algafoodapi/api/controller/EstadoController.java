package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<Estado> listar() {
        return estadoService.listar();
    }

    @GetMapping("/{id}")
    public Estado buscar(@PathVariable Long id) {
        return estadoService.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return estadoService.salvar(estado);
    }

    @PutMapping("/{id}")
    public Estado atualizar(@PathVariable Long id, @RequestBody Estado estado) {
        Estado estadoAtual = estadoService.buscar(id);
        BeanUtils.copyProperties(estado, estadoAtual, "id");
        return estadoService.salvar(estadoAtual);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        estadoService.excluir(id);
    }

}
