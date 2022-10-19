package br.com.restaurante.view;

import java.util.Scanner;

public class View {

	public Integer opcoesMenu(Scanner scanner) {
		System.out.println("Bem-vindo ao Restaurante!");
		System.out.println("");
		System.out.println("1- Cadastrar Novos Produtos");
		System.out.println("2- Listar Produtos");
		System.out.println("3- Alterar Produto pelo ID");
		System.out.println("4- Deletar Produto pelo ID");
		System.out.println("5- Cadastrar Cliente");
		System.out.println("6- Cadastrar Novo Pedido Cliente");
		System.out.println("7- Listar contas abertas e subtotal por enquanto");
		System.out.println("8- Fechar Conta Cliente");
		System.out.println("9- Encerrar aplicação!");
		
		return scanner.nextInt();
	}
	
	public Integer getTipoProduto(Scanner scanner) {
		System.out.println("Qual o tipo de produto que deseja cadastrar?");
		System.out.println("1- Salgado Frito");
		System.out.println("2- Salgado Assado");
		System.out.println("3- Refresco");
		System.out.println("4- Cancelar operação!");
		
		return scanner.nextInt();
	}

	public String getNomeProduto(Scanner scanner) {
		System.out.println("Qual nome do Produto?");
		
		return scanner.next();
	}

	public Double getValorProduto(Scanner scanner) {
		System.out.println("Qual o valor do Produto?");
		
		return scanner.nextDouble();
	}
	
}
