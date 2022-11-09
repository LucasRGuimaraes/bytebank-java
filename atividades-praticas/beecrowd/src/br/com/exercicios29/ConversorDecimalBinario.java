package br.com.exercicios29;

public class ConversorDecimalBinario {

	public static void main(String[] args) {

		Integer numero = 25;
		Integer dividido = numero;
		String binario = "";

		while (dividido != 1) {
			
			if (dividido % 2 == 1) {
				binario = binario + "1";
				dividido = (dividido - 1) / 2;
			} else if (dividido % 2 == 0) {
				binario = binario + "0";
				dividido = dividido / 2;
			}

		}
		
		binario = binario + "1";
		
		binario = new StringBuilder(binario).reverse().toString();
		
		System.out.println("O binario de " + numero + " é " + binario);

	}

}
