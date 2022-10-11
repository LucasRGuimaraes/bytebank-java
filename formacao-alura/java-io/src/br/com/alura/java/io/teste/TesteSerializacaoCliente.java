package br.com.alura.java.io.teste;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TesteSerializacaoCliente {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
//		Cliente cliente = new Cliente();
//		cliente.setNome("Lucas");
//		cliente.setProfissao("Dev");
//		cliente.setCpf("12209485789");
//		
//		ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("cliente.bin"));
//		oss.writeObject(cliente);
//		oss.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objeto.bin"));
		Cliente cliente = (Cliente) ois.readObject();
		ois.close();
		System.out.println(cliente.getCpf());
	}
}
