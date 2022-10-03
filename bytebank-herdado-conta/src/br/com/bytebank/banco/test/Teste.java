package br.com.bytebank.banco.test;

import java.util.Iterator;

public class Teste {

		public static void main(String[] args) {
			int [] idades = new int[5];
			
			for (int i = 0; i < idades.length; i++) {
				idades[i] = i * i;
			}
			
			for (int i = 0; i < idades.length; i++) {
				System.out.println(idades[i]);
			}
		}
}
