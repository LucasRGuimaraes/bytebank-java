package br.com.restaurante.service;

import java.util.List;
import java.util.Optional;

import br.com.restaurante.database.SingletonDB;
import br.com.restaurante.modelo.Cliente;
import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.dto.ClienteDTO;

public class ClienteService {

  private SingletonDB db = SingletonDB.getInstance();

  public List<Cliente> getClientes() {
    return db.getClientes();
  }

  public Cliente getClienteById(Integer id) {
    Optional<Cliente> cliente = db.findClienteById(id);
    if (!cliente.isEmpty()) {
      return cliente.get();
    }
    return null;
  }

  public void cadastrarCliente(ClienteDTO clienteDTO) {
    db.registraCliente(new Cliente(db.getSequenceClienteId(), clienteDTO.getNome(), clienteDTO.getNumeroMesa()));
  }

  public void cadastrarProdutoNoCliente(Integer idDoCliente, Produto produto) {
    this.getClienteById(idDoCliente).cadastrarProdutoNoCliente(produto);
  }

  public void removerCliente(Integer id) {
    db.deletarCliente(this.getClienteById(id));
  }

}
