package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

  RECURSO_NAO_ENCONTRADO("/resource-not-found", "Resource not found"),
  ENTIDADE_EM_USO("/entity-in-use", "Entity in use"),
  PARAMETRO_INVALIDO("/invalid-parameter", "Invalid parameter"),
  ERRO_NEGOCIO("/error-business", "Business rule violation"),
  MENSAGEM_ILEGIVEL("/unreadable-message", "Unreadable message"),
  DADOS_INVALIDOS("/invalid-data", "Invalid data"),
  ERRO_DE_SISTEMA("/system-error", "System error");
  
  private String title;
  private String uri;
  
  ProblemType(String path, String title) {
    this.uri = "https://algafood,com.br" + path;
    this.title = title;
  }
  
  
}
