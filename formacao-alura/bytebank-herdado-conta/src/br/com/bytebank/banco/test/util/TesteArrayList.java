package br.com.bytebank.banco.test.util;

import java.util.ArrayList;
import java.util.Iterator;

import br.com.bytebank.banco.modelo.Conta;
import br.com.bytebank.banco.modelo.ContaCorrente;

public class TesteArrayList {
	public static void main(String[] args) {
		
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc1 = new ContaCorrente(1, 1);
		lista.add(cc1);
		
		Conta cc2 = new ContaCorrente(2, 2);
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(3, 3);
		lista.add(cc3);
		
		System.out.println(lista.size());
		
		Conta ref = lista.get(0);
		System.out.println(ref);
		
		lista.remove(0);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta cc4 = new ContaCorrente(4, 4);
		lista.add(cc4);
		
		Conta cc5 = new ContaCorrente(5, 5);
		lista.add(cc5);
		
		for (int i = 0; i < lista.size(); i++) {
			Object oRef = lista.get(i);
			System.out.println(oRef);
		}
		
		for (Conta conta : lista) {
			System.out.println(conta );
		}
		
		
	}
}
