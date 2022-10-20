package br.com.restaurante.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

  private Integer id;
  private String nome;
  private Integer numeroMesa;
  private List<Produto> produtosConsumidos = new ArrayList<>();

  public Cliente(Integer id, String nome, Integer numeroMesa) {
    this.id = id;
    this.nome = nome;
    this.numeroMesa = numeroMesa;
  }

  public Double getSubtotal() {
    return this.produtosConsumidos.stream().map(Produto::getValor).reduce(0d, Double::sum);
  }

  public void cadastrarProdutoNoCliente(Produto produto) {
    this.produtosConsumidos.add(produto);
  }

  public Integer getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public Integer getNumeroMesa() {
    return numeroMesa;
  }

  public List<Produto> getProdutosConsumidos() {
    return produtosConsumidos;
  }

  @Override
  public String toString() {
    return String.format("%10s%20s%10s%20s", this.id, this.nome, this.numeroMesa, this.getSubtotal());
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    Cliente other = (Cliente) obj;
    return Objects.equals(id, other.id);
  }
}
