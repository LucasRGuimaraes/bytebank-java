package br.com.restaurante.view;

import java.util.Scanner;

public class View {

	public Integer opcoesMenu(Scanner scanner) {
		System.out.println("Bem-vindo ao restaurante!");
		System.out.println("");
		System.out.println("1- Cadastrar novo produto");
		System.out.println("2- Listar produtos");
		System.out.println("3- Alterar produto pelo ID");
		System.out.println("4- Deletar produto pelo ID");
		System.out.println("5- Cadastrar cliente");
		System.out.println("6- Cadastrar novo pedido no cliente");
		System.out.println("7- Listar contas abertas e subtotal por enquanto");
		System.out.println("8- Fechar conta do cliente");
		System.out.println("9- Encerrar aplicação!");

		return scanner.nextInt();
	}

	public void opcaoInvalida() {
		System.out.println("Por favor insira um valor válido!");
	}

	public void encerrandoPrograma() {
		System.out.println("Programa encerrado!");
	}

	public boolean confirmarOperacao(Scanner scanner) {
		System.out.println("Confirmar operação (Y/N)");
		if (scanner.next().contains("y")) {
			return true;
		}
		return false;
	}

}
