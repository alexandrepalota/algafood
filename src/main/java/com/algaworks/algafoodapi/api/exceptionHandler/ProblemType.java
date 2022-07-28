package com.algaworks.algafoodapi.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    PARAMETRO_INVALIDO("/parametro-invalido", "Parâmetro inválido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensível"),
    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-de-negocio", "Erro de negócio");

    private String title;
    private String uri;

    ProblemType(String path, String title) {
        this.uri = "http://algafood.com.br" + path;
        this.title = title;
    }
}
