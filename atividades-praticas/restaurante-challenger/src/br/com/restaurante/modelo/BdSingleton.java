package br.com.restaurante.modelo;

import java.util.ArrayList;
import java.util.List;

public final class BdSingleton {
    private static BdSingleton instance;
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private int sequenceProdutos = 0;
    private int sequenceClientes = 0;
    
    public static BdSingleton getInstance() {
    	if (instance == null) {
    		instance = new BdSingleton();
    	}
    	return instance;
    }
    
    public int getNextProduto () {
    	return sequenceProdutos++;
    }
    
    public int getNextCliente () {
    	return sequenceClientes++;
    }
    
	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}