package br.com.restaurante.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	private Integer numeroMesa;
	private String nomeCliente;
	private List<Produto> produtosConsumidos = new ArrayList<>();
	
	public Cliente(Integer numeroMesa, String nomeCliente) {
		this.numeroMesa = numeroMesa;
		this.nomeCliente = nomeCliente;
	}

	public Cliente(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}

	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}

	public void setProdutosConsumidos(ArrayList<Produto> produtosConsumidos) {
		this.produtosConsumidos = produtosConsumidos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numeroMesa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(numeroMesa, other.numeroMesa);
	}

	@Override
	public String toString() {
		return String.format("%20s%20s", numeroMesa, nomeCliente);
	}

}
