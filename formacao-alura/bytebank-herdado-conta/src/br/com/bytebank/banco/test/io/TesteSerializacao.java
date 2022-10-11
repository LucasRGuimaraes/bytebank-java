package br.com.bytebank.banco.test.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import br.com.bytebank.banco.modelo.Cliente;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteSerializacao {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Cliente cliente = new Cliente();
		cliente.setNome("Lucas");
		cliente.setProfissao("Dev");
		cliente.setCpf("12209485789");
		
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.setTitular(cliente);
		cc.deposita(222.3);
		
		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oss.writeObject(cc);
		oss.close();
	}
}
