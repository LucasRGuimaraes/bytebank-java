package br.com.restaurante.modelo;

import java.util.Objects;

public abstract class Produto {

	private Integer id;
	private String nome;
	private Double valor;

	public Produto(Integer id, String nome, Double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
