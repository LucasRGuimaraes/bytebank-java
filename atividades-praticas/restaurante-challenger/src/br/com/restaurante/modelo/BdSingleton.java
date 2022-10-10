package br.com.restaurante.modelo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BdSingleton {
	private static BdSingleton instance;
	private List<Produto> produtos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private int sequenceProdutos = 0;
	private int sequenceClientes = 0;

	public static BdSingleton getInstance() {
		if (instance == null) {
			instance = new BdSingleton();
			loadProdutos();
			loadClientes();
		}
		return instance;
	}

	private static void loadProdutos() {
		try {
			String dados = new String(Files.readAllBytes(new File("produtos.csv").toPath()));
			String[] rows = dados.split("\r\n");
			Arrays.asList(rows).forEach(row -> {
				String[] category = row.split(",");
				String id = category[0];
				String type = category[1];
				String name = category[2];
				String price = category[3];

				Produto produto = null;

				if (type.equals(SalgadoFrito.class.getSimpleName())) {
					produto = new SalgadoFrito(Integer.parseInt(id), name, Double.parseDouble(price));
				} else if (type.equals(SalgadoAssado.class.getSimpleName())) {
					produto = new SalgadoAssado(Integer.parseInt(id), name, Double.parseDouble(price));
				} else if (type.equals(Refresco.class.getSimpleName())) {
					produto = new Refresco(Integer.parseInt(id), name, Double.parseDouble(price));
				}

				instance.getProdutos().add(produto);

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadClientes() {
		try {
			String dados = new String(Files.readAllBytes(new File("clientes.csv").toPath()));
			String[] rows = dados.split("\r\n");
			Arrays.asList(rows).forEach(row -> {
				String[] category = row.split(",");
				String id = category[0];
				String name = category[1];
				String[] produtos = category[2].replaceAll("\\[|\\]", "").split(";");
				System.out.println(Arrays.asList(produtos));
				
				Cliente cliente = new Cliente(Integer.parseInt(id), name);
				
				instance.getProdutos().forEach(produto -> {
//					produto.getId().equals()
				});
				
				
				
//				cliente.getProdutosConsumidos().add(null)

				instance.getClientes().add(cliente);

			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNextProduto() {
		return sequenceProdutos++;
	}

	public int getNextCliente() {
		return sequenceClientes++;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void addProduto(Produto produto) {
		produtos.add(produto);
	}
	
//	public Produto findProdutoById(int id) {
		
		
		
//	}

}