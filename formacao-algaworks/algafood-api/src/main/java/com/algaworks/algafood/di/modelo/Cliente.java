package com.algaworks.algafood.di.modelo;

public class Cliente {

	private String nome;
	private String email;
	private String telefone;
	private Boolean ativo = false;
	
	public Cliente(String nome, String email, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void ativar() {
		this.ativo = true;
	}
	
	
	
	
}
