package br.com.restaurante.modelo.dto;

public class ProdutoDTO {

	private Integer tipo;
	private String nome;
	private Double valor;
	
 	public ProdutoDTO(Integer tipo, String nome, Double valor) {
		this.tipo = tipo;
		this.nome = nome;
		this.valor = valor;
	}

	public Integer getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

}
