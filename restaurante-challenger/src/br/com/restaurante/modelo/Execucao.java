package br.com.restaurante.modelo;

import java.util.Scanner;

import br.com.restaurante.service.RestauranteService;

public class Execucao {

	public static void opcoes() {

		System.out.println("Bem vindo a este sistema maluco de um restaurante, selecione a opção que deseja realizar: \n"
				+ "1- Cadastrar Novo Produto\n" + "2- Listar Produtos\n" + "3- Alterar Produto pelo ID\n"
				+ "4- Deletar Produto pelo ID\n" + "5- Cadastrar Cliente\n" + "6- Cadastrar Novo Pedido Cliente\n"
				+ "7- Listar contas abertas e subtotal por enquanto\n" + "8- Fechar Conta Cliente\n" + "9- Encerrar programa!\n");
	}

	public static void main(String[] args) {
		
		RestauranteService rs = new RestauranteService();
		
		opcoes();
		
		int opcao = 0;
		while (opcao != 9) {

			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();
			
			switch (opcao) {
			case 1:
				System.out.println("Cadastrar novo Produto: ");
				rs.cadastrarProduto();
				break;

			case 2:
				System.out.println("Listar Produtos: ");
				rs.listarProdutos();
				break;

			case 3:
				System.out.println("Alterar Produto pelo ID: ");
				break;

			case 4:
				System.out.println("Deletar Produto pelo ID: ");
				break;

			case 5:
				System.out.println("Cadastrar Cliente: ");
				break;

			case 6:
				System.out.println("Cadastrar novo pedido Cliente: ");
				break;

			case 7:
				System.out.println("Listar contar abertas e subtotal por enquanto: ");
				break;

			case 8:
				System.out.println("Fechar conta do Cliente: ");
				break;

			case 9:
				System.out.println("Programa Encerrado!");
				break;

			default:
				System.out.println("Insira um numero valido");
			}

		}
	}
}
