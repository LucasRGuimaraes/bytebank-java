package br.com.restaurante.service;

import java.util.List;
import java.util.Scanner;

import br.com.restaurante.exceptions.DeleteException;
import br.com.restaurante.exceptions.ServiceException;
import br.com.restaurante.modelo.BdSingleton;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.Refresco;
import br.com.restaurante.modelo.SalgadoAssado;
import br.com.restaurante.modelo.SalgadoFrito;

public class ProdutoService {

	BdSingleton bd = BdSingleton.getInstance();

	public void cadastrarProduto() {

		System.out.println("Escolha um tipo de produto:");
		System.out.println("1- Salgado Frito");
		System.out.println("2- Salgado Assado");
		System.out.println("3- Refresco");
		System.out.println("4- Cancelar operação!");

		int opcao = 0;
		String nome = "";
		double valor = 0;

		while (opcao != 4) {
			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Qual o nome do SALGADO FRITO?");
				nome = scan.next();

				System.out.println("Qual o valor do " + nome + "?");
				valor = scan.nextDouble();

				SalgadoFrito sf = new SalgadoFrito(bd.getNextProduto(), nome, valor);
				bd.addProduto(sf);

				return;

			case 2:
				System.out.println("Qual o nome do SALGADO ASSADO?");
				nome = scan.next();

				System.out.println("Qual o valor do " + nome + "?");
				valor = scan.nextDouble();

				SalgadoAssado sa = new SalgadoAssado(bd.getNextProduto(), nome, valor);
				bd.addProduto(sa);
				return;

			case 3:
				System.out.println("Qual o nome do REFRESCO?");
				nome = scan.next();

				System.out.println("Qual o valor do " + nome + "?");
				valor = scan.nextDouble();

				Refresco r = new Refresco(bd.getNextProduto(), nome, valor);
				bd.addProduto(r);
				return;

			case 4:
				System.out.println("Operação cancelada!");
				return;

			default:
				System.out.println("Insira um número valido!\n");
			}
		}
	}

	public void listarProdutos() {
		List<Produto> produtos = bd.getProdutos();
		System.out.printf("%10s%20s%10s%10s\n", "ID", "TIPO","NOME","VALOR");
		produtos.forEach(System.out::println);
	}

	public void alterarProduto(int id) throws ServiceException {
		deletarProduto(id);
		cadastrarProduto();
	}

	public void deletarProduto(int id) throws DeleteException {
		List<Produto> produtos = bd.getProdutos();
		if (!produtos.remove(new Produto(id))) {
			throw new DeleteException("\nProduto" + id + " não encontrado!\n");
		}
	}

	public void listarProdutosPeloTipo(int tipoProduto) {
		List<Produto> produtos = bd.getProdutos();

		produtos.forEach(produto -> {

			switch (tipoProduto) {
			case 1:
				if(produto instanceof SalgadoFrito) {
					System.out.println(produto);
				}
				break;

			case 2:
				if(produto instanceof SalgadoAssado) {
					System.out.println(produto);
				}
				break;

			case 3:
				if(produto instanceof Refresco) {
					System.out.println(produto);
				}
				break;

			default:
				System.out.println("Insira um número valido!\n");
			}
		});

	}
}
