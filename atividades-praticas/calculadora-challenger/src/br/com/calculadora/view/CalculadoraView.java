package br.com.calculadora.view;

import java.util.Scanner;

public class CalculadoraView {
	
	Scanner scanner = new Scanner(System.in);

	public Integer pedirPrimeiroValor() {
		System.out.print("Insira o primeiro valor inteiro: ");
		return scanner.nextInt();
	}
	
	public char pedirTipoDeOperacao() {
		
		System.out.println("Insira o valor referente a um tipo de operação:");
		System.out.println("Para somar insira: +");
		System.out.println("Para subtrair insira: -");
		System.out.println("Para multiplicar insira: *");
		System.out.println("Para dividir insira: /");
		
		return scanner.next().charAt(0);
	}
	
	public Integer pedirSegundoValor() {
		System.out.print("Insira o segundo valor inteiro: ");
		return scanner.nextInt();
	}

	public void imprimirResultado(Integer resultado) {
		System.out.println("O resultado da operação foi: " + resultado);
	}
	
	

	
	
}
