package br.com.restaurante.database;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import br.com.restaurante.modelo.Cliente;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.Refresco;
import br.com.restaurante.modelo.SalgadoAssado;
import br.com.restaurante.modelo.SalgadoFrito;

public class SingletonDB {

	private static SingletonDB instance = null;
	private List<Produto> produtos = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private Integer sequenceProdutoId = 0;
	private Integer sequenceClienteId = 0;

	private SingletonDB() {
	};

	public static SingletonDB getInstance() {
		if (instance == null) {
			instance = new SingletonDB();
			instance.loadProdutos();
		}
		return instance;
	}

	public void loadProdutos() {
		try {
			Files.lines(Paths.get(
					"C:\\Users\\LucasGuimaraes\\Workspace\\Estudos\\Java\\atividades-praticas\\restaurante-challenger-v2\\src\\produtos.csv"))
					.map(line -> line.split("\\|\\|"))
					.forEach(category -> {
						String id = category[0];
						String type = category[1];
						String name = category[2];
						String price = category[3];
						Produto produto = null;

						if (type.equals(SalgadoFrito.class.getSimpleName())) {
							produto = new SalgadoFrito(Integer.parseInt(id), name,
									Double.parseDouble(price));
						} else if (type.equals(SalgadoAssado.class.getSimpleName())) {
							produto = new SalgadoAssado(Integer.parseInt(id), name,
									Double.parseDouble(price));
						} else if (type.equals(Refresco.class.getSimpleName())) {
							produto = new Refresco(Integer.parseInt(id), name,
									Double.parseDouble(price));
						}

						registraProduto(produto);
						this.setSequenceProdutoId(Integer.parseInt(id) + 1);
					});
		} catch (

		Exception e) {
		}
	}

	public List<Produto> getProdutos() {
		return Collections.unmodifiableList(produtos);
	}

	public Integer getSequenceProdutoId() {
		return this.sequenceProdutoId++;
	}

	public void setSequenceProdutoId(Integer sequenceProdutoId) {
		this.sequenceProdutoId = sequenceProdutoId;
	}

	public void registraProduto(Produto produto) {
		this.produtos.add(produto);
	}

	public void deletaProduto(Produto produto) {
		this.produtos.remove(produto);
	}

	public Optional<Produto> findProdutoById(Integer id) {
		return this.produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
	}

	public Optional<Cliente> findClienteById(Integer id) {
		return this.clientes.stream().filter(c -> c.getId().equals(id)).findFirst();
	}

	public List<Cliente> getClientes() {
		return Collections.unmodifiableList(clientes);
	}

	public Integer getSequenceClienteId() {
		return this.sequenceClienteId++;
	}

	public void registraCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}

	public void deletarCliente(Cliente cliente) {
		this.clientes.remove(cliente);
	}

}
