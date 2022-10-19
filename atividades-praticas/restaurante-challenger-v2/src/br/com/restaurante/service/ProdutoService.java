package br.com.restaurante.service;

import br.com.restaurante.database.SingletonDB;
import br.com.restaurante.modelo.SalgadoFrito;
import br.com.restaurante.modelo.dto.ProdutoDTO;

public class ProdutoService {
	
	SingletonDB db = SingletonDB.getInstance();

	public void cadastrarProduto(ProdutoDTO produtoDTO) {
		
		switch (produtoDTO.getTipo()) {
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
