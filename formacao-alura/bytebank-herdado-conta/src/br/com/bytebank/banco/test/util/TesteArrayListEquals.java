package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayListEquals {
	public static void main(String[] args) {
		
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc1 = new ContaCorrente(1, 1);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(2, 2);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(3, 3);
		boolean existe = lista.contains(cc3);
		
		System.out.println("Já existe? " + existe);
		
		for (Conta conta : lista) {
			if (conta.ehIgual(cc2)) {
				System.out.println("Já tenho essa conta!");				
			}
		}
	}
}
