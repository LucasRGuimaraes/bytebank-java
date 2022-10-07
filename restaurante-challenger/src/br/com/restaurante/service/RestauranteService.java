package br.com.restaurante.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.restaurante.modelo.BdSingleton;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.Refresco;
import br.com.restaurante.modelo.SalgadoAssado;
import br.com.restaurante.modelo.SalgadoFrito;

public class RestauranteService {

	BdSingleton bd = BdSingleton.getInstance();

	public void cadastrarProduto() {

		System.out.println("Escolha um tipo de produto: \n" + "1- Salgado Frito\n" + "2- Salgado Assado\n"
				+ "3- Refresco\n" + "4- Cancelar operação!\n");

		int opcao = 0;
		String nome = "";
		double valor = 0;
		
		a:
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
				bd.getProdutos().add(sf);
				
				break a;

			case 2:
				System.out.println("Qual o nome do SALGADO ASSADO?");
				nome = scan.next();
				
				System.out.println("Qual o valor do " + nome + "?");
				valor = scan.nextDouble();
				
				SalgadoAssado sa = new SalgadoAssado(bd.getNextProduto(), nome, valor);
				bd.getProdutos().add(sa);
				break a;

			case 3:
				System.out.println("Qual o nome do REFRESCO?");
				nome = scan.next();
				
				System.out.println("Qual o valor do " + nome + "?");
				valor = scan.nextDouble();
				
				Refresco r = new Refresco(bd.getNextProduto(), nome, valor);
				bd.getProdutos().add(r);
				break a;

			case 4:
				System.out.println("Operação cancelada!");
				break a;

			default:
				System.out.println("Insira um numero valido!\n");
			}
		}
	}
	
	public void listarProdutos() {
		List<Produto> produtos = bd.getProdutos();
		produtos.forEach(produto -> System.out.println(produto));
	}

}
