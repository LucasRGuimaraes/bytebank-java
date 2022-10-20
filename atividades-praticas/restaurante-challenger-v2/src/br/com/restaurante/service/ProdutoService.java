package br.com.restaurante.service;

import java.util.List;
import java.util.Optional;

import br.com.restaurante.database.SingletonDB;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.Refresco;
import br.com.restaurante.modelo.SalgadoAssado;
import br.com.restaurante.modelo.SalgadoFrito;
import br.com.restaurante.modelo.dto.ProdutoDTO;

public class ProdutoService {

	private SingletonDB db = SingletonDB.getInstance();

	public List<Produto> getProdutos() {
		return db.getProdutos();
	}

	public Produto getProdutoById(Integer id) {
		Optional<Produto> produto = db.findProdutoById(id);
		if (!produto.isEmpty()) {
			return produto.get();
		}
		return null;
	}

	public void cadastrarProduto(ProdutoDTO produtoDTO) {
		if (produtoDTO != null) {

			switch (produtoDTO.getTipo()) {
				case 1:
					db.registraProduto(new SalgadoFrito(db.getSequenceProdutoId(), produtoDTO.getNome(),
							produtoDTO.getValor()));
					break;

				case 2:
					db.registraProduto(new SalgadoAssado(db.getSequenceProdutoId(), produtoDTO.getNome(),
							produtoDTO.getValor()));
					break;

				case 3:
					db.registraProduto(new Refresco(db.getSequenceProdutoId(), produtoDTO.getNome(), produtoDTO.getValor()));
					break;
			}
		}
	}

	public void removerProduto(Integer id) {
		db.deletaProduto(this.getProdutoById(id));
	}

	public void alterarProduto(Integer idProdutoAntigo, ProdutoDTO novoProdutoDTO) {
		this.removerProduto(idProdutoAntigo);
		this.cadastrarProduto(novoProdutoDTO);
	}

}
