package br.com.restaurante.database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.restaurante.modelo.Produto;

public class SingletonDB {

	private static SingletonDB instance = null;
	private List<Produto> produtos = new ArrayList<>();

	private SingletonDB() {
	};

	public static SingletonDB getInstance() {
		if (instance == null)
			return instance = new SingletonDB();
		return instance;
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public void registraProduto(Produto produto) {
		this.produtos.add(produto);
	}

}
