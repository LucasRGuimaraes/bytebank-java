package br.com.restaurante.service;

import br.com.restaurante.database.SingletonDB;
import br.com.restaurante.modelo.SalgadoFrito;

public class ProdutoService {
	
	SingletonDB db = SingletonDB.getInstance();

	public void cadastrarProduto(Integer tipo, String nome, Double valor) {
		
		switch (tipo) {
		case 1:
			new SalgadoFrito(tipo, nome, valor);
			break;
			
		case 2:
			break;
			
		case 3:
			break;
			
		case 4:
			break;
		
		default:
			break;
		}
	}
	
}
