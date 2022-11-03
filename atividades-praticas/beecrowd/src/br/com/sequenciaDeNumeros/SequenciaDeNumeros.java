package br.com.sequenciaDeNumeros;

public class SequenciaDeNumeros {

	public static void main(String[] args) {

		Integer valor1 = 10;
		Integer valor2 = 13;
		String sequencia = "";
		String reverseSequencia = "";

		for (int i = valor1; i <= valor2; i++) {
			sequencia += i;
		}

		for (int i = 0; i < sequencia.length(); i++) {
			reverseSequencia = sequencia.charAt(i) + reverseSequencia;
		}
		
		System.out.println(sequencia + reverseSequencia);

	}

}
