package br.com.exercicios29;

public class VerificacaoNumeroPrimo {

	public static void main(String[] args) {

		Integer numero = 113;
		boolean isPrimo = true;
		
		for (int i = 2; i < numero; i++) {
			if(numero % i == 0) {
				isPrimo = false;
			}
		}
		
		if(isPrimo) {
			System.out.println(numero + " é primo");
		} else {
			System.out.println(numero + " não é primo");
		}
	}
	
}
