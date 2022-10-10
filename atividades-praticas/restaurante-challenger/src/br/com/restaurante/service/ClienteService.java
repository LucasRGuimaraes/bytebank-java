package br.com.restaurante.service;

import java.util.List;
import java.util.Scanner;

import br.com.restaurante.exceptions.DeleteException;
import br.com.restaurante.modelo.BdSingleton;
import br.com.restaurante.modelo.Cliente;
import br.com.restaurante.modelo.Produto;

public class ClienteService {

	BdSingleton bd = BdSingleton.getInstance();

	public void cadastrarCliente() {
		System.out.println("Qual o nome do cliente? \n");

		String nomeCliente = new Scanner(System.in).next();
		Cliente cliente = new Cliente(bd.getNextCliente(), nomeCliente);

		bd.getClientes().add(cliente);
	}

	public void cadastrarPedido(int numeroMesa, int idProduto) {
		List<Cliente> clientes = bd.getClientes();
		List<Produto> produtos = bd.getProdutos();

		int indexOfCliente = clientes.indexOf(new Cliente(numeroMesa));
		int indexOfProduto = produtos.indexOf(new Produto(idProduto));
		if (indexOfCliente != -1 && indexOfProduto != -1) {
			clientes.get(indexOfCliente).getProdutosConsumidos().add(produtos.get(indexOfProduto));
			System.out.println("Produto registrado com sucesso!");
		}
	}

	public void listarClientes() {
		List<Cliente> clientes = bd.getClientes();
		System.out.printf("%20s%20s%20s\n", "Número Mesa", "Nome Cliente", "Subtotal");
		clientes.forEach(cliente -> {
			List<Produto> produtos = cliente.getProdutosConsumidos();
			Double subtotal = produtos.stream().map(Produto::getValor).reduce(0d, Double::sum);

			System.out.printf("%20s%20s%20s\n", cliente.getNumeroMesa(), cliente.getNomeCliente(), subtotal);
		});
	}

	public void fecharMesa(int fecharMesaId) throws DeleteException {
		List<Cliente> clientes = bd.getClientes();

		int indexOfCliente = clientes.indexOf(new Cliente(fecharMesaId));
		if (indexOfCliente != -1) {
			Cliente cliente = clientes.get(indexOfCliente);
			List<Produto> produtos = cliente.getProdutosConsumidos();
			
			Double subtotal = produtos.stream().map(Produto::getValor).reduce(0d, Double::sum);
			
			produtos.forEach(produto -> System.out.println(produto));
			System.out.println("Total a pagar: " + subtotal * 1.1);
		}

		if (!clientes.remove(new Cliente(fecharMesaId))) {
			throw new DeleteException("\nMesa " + fecharMesaId + " não encontrado!\n");
		}

	}

}
