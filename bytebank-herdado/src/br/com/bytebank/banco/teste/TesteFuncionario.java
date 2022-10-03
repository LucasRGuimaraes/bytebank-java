package br.com.bytebank.banco.teste;
import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.Gerente;

public class TesteFuncionario {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		
		Gerente lucas = new Gerente();
		lucas.setNome("Lucas");
		lucas.setCpf("1231213");
		lucas.setSalario(2800.00);
		
		System.out.println(lucas.getNome());
		System.out.println(lucas.getBonificacao());
	}
}
