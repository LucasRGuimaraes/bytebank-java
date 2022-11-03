package br.com.restaurante.controller;

import java.util.List;
import java.util.Scanner;

import br.com.restaurante.modelo.Cliente;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.service.ClienteService;
import br.com.restaurante.service.ProdutoService;
import br.com.restaurante.view.ClienteView;
import br.com.restaurante.view.ProdutoView;
import br.com.restaurante.view.View;

public class Executador {

	public static void main(String[] args) {

		View view = new View();
		ProdutoView produtoView = new ProdutoView();
		ClienteView clienteView = new ClienteView();
		ProdutoService produtoService = new ProdutoService();
		ClienteService clienteService = new ClienteService();

		Scanner scanner = new Scanner(System.in);

		Integer opcao = 0;
		while (opcao != 9) {
			opcao = view.opcoesMenu(scanner);

			switch (opcao) {
				case 1: // Cadastrar Novos Produtos
					produtoService.cadastrarProduto(produtoView.getInformacoesProduto(scanner));
					break;

				case 2: // Listar Produtos
					produtoView.listarProdutos(produtoService.getProdutos());
					break;

				case 3: // Alterar Produto pelo ID
					produtoView.listarProdutos(produtoService.getProdutos());
					produtoService.alterarProduto(produtoView.getIdDoProduto(scanner),
							produtoView.getInformacoesProduto(scanner));
					break;

				case 4: // Deletar Produto pelo ID
					produtoView.listarProdutos(produtoService.getProdutos());
					produtoService.removerProduto(produtoView.getIdDoProduto(scanner));
					break;

				case 5: // Cadastrar Cliente
					clienteService.cadastrarCliente(clienteView.getInformacoesCliente(scanner));
					break;

				case 6: // Cadastrar Novo Pedido Cliente
					clienteView.listarClientes(clienteService.getClientes());
					Integer idDoCliente = clienteView.getIdDoCliente(scanner);

					produtoView.listarProdutos(produtoService.getProdutos());
					Produto produto = produtoService.getProdutoById(produtoView.getIdDoProduto(scanner));

					clienteService.cadastrarProdutoNoCliente(idDoCliente, produto);
					clienteView.listarClientes(clienteService.getClientes());
					break;

				case 7: // Listar contas abertas e subtotal por enquanto
					clienteView.listarClientes(clienteService.getClientes());
					break;

				case 8: // Fechar Conta Cliente
					List<Cliente> todosClientes = clienteService.getClientes();
					clienteView.listarClientes(todosClientes);

					Integer id = clienteView.getIdDoCliente(scanner);
					Cliente cliente = clienteService.getClienteById(id);

					clienteView.listarFechamentoDeCliente(cliente);
					if (view.confirmarOperacao(scanner)) {
						clienteService.removerCliente(id);
					}
					clienteView.listarClientes(todosClientes);
					break;

				case 9:
					view.encerrandoPrograma();
					break;

				default:
					view.opcaoInvalida();
					break;
			}

		}
	}
}
