package br.com.provaThiago;

public class Exercicio1 {

	public static void main(String[] args) {
		
		String frase = "Eu vou me dar bem na prova de PE";
		Integer qntdA = 0;
		Integer qntdE = 0;
		Integer qntdI = 0;
		Integer qntdO = 0;
		Integer qntdU = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			
			switch (Character.toString(frase.charAt(i)).toLowerCase()) {
			case "a" -> qntdA++;
			case "e" -> qntdE++;
			case "i" -> qntdI++;
			case "o" -> qntdO++;
			case "u" -> qntdU++;
			}
			
		}
		
		System.out.printf("a - %d, e - %d, i - %d, o - %d, u - %d", qntdA, qntdE, qntdI, qntdO, qntdU);
		
	}
}