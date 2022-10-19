package br.com.restaurante.modelo;

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
	
}
