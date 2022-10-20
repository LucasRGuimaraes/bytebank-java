package br.com.restaurante.view;

import java.util.List;
import java.util.Scanner;

import br.com.restaurante.modelo.Cliente;
import br.com.restaurante.modelo.dto.ClienteDTO;

public class ClienteView {

  public ClienteDTO getInformacoesCliente(Scanner scanner) {
    System.out.println("Qual o nome do cliente?");
    String nome = scanner.next();

    System.out.println("Qual o número da mesa do " + nome + "?");
    Integer numeroMesa = scanner.nextInt();

    return new ClienteDTO(nome, numeroMesa);
  }

  public void listarClientes(List<Cliente> clientes) {
    System.out.printf("%10s%20s%10s%20s\n", "ID", "NOME", "MESA", "SUBTOTAL");
    clientes.forEach(System.out::println);
  }

  public Integer getIdDoCliente(Scanner scanner) {
    System.out.println("Qual o ID do cliente?");
    return scanner.nextInt();
  }

  public void listarFechamentoDeCliente(Cliente cliente) {
    System.out.println("Fechamento do cliente " + cliente.getNome() + " da mesa " + cliente.getNumeroMesa());
    cliente.getProdutosConsumidos().forEach(System.out::println);
    System.out.println("Total consumido: " + cliente.getSubtotal() + " + 10%: R$" + cliente.getSubtotal() * 1.1);
  }

}
