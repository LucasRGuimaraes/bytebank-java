package br.com.restaurante.modelo.dto;

import java.lang.reflect.Constructor;

public class ClienteDTO {

  private String nome;
  private Integer numeroMesa;

  public ClienteDTO(String nome, Integer numeroMesa) {
    this.nome = nome;
    this.numeroMesa = numeroMesa;
  }

  public Integer getNumeroMesa() {
    return numeroMesa;
  }

  public String getNome() {
    return nome;
  }

}
