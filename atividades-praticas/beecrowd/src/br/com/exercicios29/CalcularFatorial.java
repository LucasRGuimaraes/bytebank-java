package br.com.exercicios29;

public class CalcularFatorial {

	public static void main(String[] args) {
		
		Integer numero = 6;
		Integer fatorial = 1;
		
		for (int i = 1; i <= numero; i++) {
			fatorial = fatorial * i;
		}
		
		System.out.println(fatorial);
		
	}
	
}
