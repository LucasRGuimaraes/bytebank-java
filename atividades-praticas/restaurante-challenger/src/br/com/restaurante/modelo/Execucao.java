package br.com.restaurante.modelo;

import java.util.Scanner;

import br.com.restaurante.exceptions.DeleteException;
import br.com.restaurante.exceptions.ServiceException;
import br.com.restaurante.service.ClienteService;
import br.com.restaurante.service.ProdutoService;

public class Execucao {

	public static void opcoes() {

		System.out.println("Bem vindo a este sistema maluco de um restaurante, selecione a opção que deseja realizar:");
		System.out.println("1- Cadastrar Novo Produto");
		System.out.println("2- Listar Produtos");
		System.out.println("3- Alterar Produto pelo ID");
		System.out.println("4- Deletar Produto pelo ID");
		System.out.println("5- Cadastrar Cliente");
		System.out.println("6- Cadastrar Novo Pedido Cliente");
		System.out.println("7- Listar contas abertas e subtotal por enquanto");
		System.out.println("8- Fechar Conta Cliente");
		System.out.println("9- Encerrar programa!");
	}

	public static void main(String[] args) {

		ProdutoService produtoService = new ProdutoService();
		ClienteService clienteService = new ClienteService();

		int opcao = 0;
		while (opcao != 9) {
			opcoes();

			Scanner scan = new Scanner(System.in);
			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("Cadastrar novo Produto: \n");

				produtoService.cadastrarProduto();
				break;

			case 2:
				System.out.println("Listar Produtos: ");
				produtoService.listarProdutos();
				break;

			case 3:
				System.out.println("Alterar Produto pelo ID: ");
				produtoService.listarProdutos();

				System.out.println("Digite o ID do produto que deseja alterar:");

				int idAlterado = new Scanner(System.in).nextInt();

				try {
					produtoService.alterarProduto(idAlterado);
					System.out.println("\nProduto" + idAlterado + " alterado com sucesso!\n");
				} catch (ServiceException e1) {
					System.out.println(e1.getMessage());
				}
				break;

			case 4:
				System.out.println("Deletar Produto pelo ID: ");
				produtoService.listarProdutos();

				System.out.println("Digite o ID do produto que deseja deletar:");

				int idDeletado = new Scanner(System.in).nextInt();

				try {
					produtoService.deletarProduto(idDeletado);
					System.out.println("\nProduto" + idDeletado + " removido com sucesso!\n");
				} catch (DeleteException e) {
					System.out.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Cadastrar Cliente: ");

				clienteService.cadastrarCliente();
				break;

			case 6:
				System.out.println("Cadastrar novo pedido Cliente: ");

				clienteService.listarClientes();

				System.out.println("Qual o numero da mesa que deseja cadastrar pedido?");
				int numeroMesa = new Scanner(System.in).nextInt();

				System.out.println("Qual tipo de produto deseja cadastrar?");
				System.out.println("1- Salgado Frito");
				System.out.println("2- Salgado Assado");
				System.out.println("3- Refresco");

				int tipoProduto = new Scanner(System.in).nextInt();
				produtoService.listarProdutosPeloTipo(tipoProduto);

				System.out.println("Qual o ID do produto que deseja cadastrar?\n");
				int idProduto = new Scanner(System.in).nextInt();

				clienteService.cadastrarPedido(numeroMesa, idProduto);

				break;

			case 7:
				System.out.println("Listar contar abertas e subtotal por enquanto: ");

				clienteService.listarClientes();
				break;

			case 8:
				System.out.println("Fechar conta do Cliente: ");

				clienteService.listarClientes();
				System.out.println("Qual o numero da mesa que deseja fechar?");

				int fecharMesaId = new Scanner(System.in).nextInt();

				try {
					clienteService.fecharMesa(fecharMesaId);
					System.out.println("\nMesa" + fecharMesaId + " encerrada com sucesso!\n");
				} catch (DeleteException e) {
					System.out.println(e.getMessage());
				}

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
