package br.com.restaurante.modelo;

import java.util.ArrayList;

public class Cliente {

	private int numeroMesa;
	private String nomeCliente;
	private ArrayList<Produto> produtosConsumidos;
	
	public int getNumeroMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public ArrayList<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}
	public void setProdutosConsumidos(ArrayList<Produto> produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;
	}
	
	
}
