package br.com.restaurante.view;

import java.util.List;
import java.util.Scanner;

import br.com.restaurante.modelo.Produto;
import br.com.restaurante.modelo.dto.ProdutoDTO;

public class ProdutoView {

  public ProdutoDTO getInformacoesProduto(Scanner scanner) {
    System.out.println("Qual o tipo de produto que deseja cadastrar?");
    System.out.println("");
    System.out.println("1- Salgado Frito");
    System.out.println("2- Salgado Assado");
    System.out.println("3- Refresco");
    System.out.println("4- Cancelar operação!");

    Integer tipo = scanner.nextInt();

    if (tipo > 0 && tipo < 4) {
      System.out.println("Qual nome do Produto?");
      String nome = scanner.next();

      System.out.println("Qual o valor do " + nome + "?");
      Double valor = scanner.nextDouble();

      return new ProdutoDTO(tipo, nome, valor);
    }
    return null;
  }

  public void listarProdutos(List<Produto> produtos) {
    System.out.printf("%10s%20s%10s%20s\n", "ID", "TIPO", "NOME", "VALOR");
    produtos.forEach(System.out::println);
  }

  public Integer getIdDoProduto(Scanner scanner) {
    System.out.println("Qual o ID do produto?");
    return scanner.nextInt();
  }
}
