package br.com.restaurante.main;

import java.util.Scanner;

import br.com.restaurante.service.ProdutoService;
import br.com.restaurante.view.View;

public class Executador {

	public static void main(String[] args) {

		ProdutoService produtoService = new ProdutoService();
		View view = new View();

		Scanner scanner = new Scanner(System.in);

		Integer opcao = 0;
		while (opcao != 9) {
			opcao = view.opcoesMenu(scanner);

			switch (opcao) {
			case 1:
				// cadastrar produto
				System.out.println("ta indo");
				produtoService.cadastrarProduto(view.getInformacoesProduto(scanner));
				break;
			default:
				break;
			}

		}
	}
}
