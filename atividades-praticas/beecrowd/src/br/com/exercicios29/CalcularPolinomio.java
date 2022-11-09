package br.com.exercicios29;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class CalcularPolinomio {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Stack<String> pilha = new Stack<String>();
		Stack<String> pilha2 = new Stack<String>();
		
		System.out.println("Insira o polinomio separando cada valor por um ESPAÇO");
		
		String polinomio = scanner.next();
		
		pilha.addAll(Arrays.asList(polinomio.split(" ")));
		
		
	}
	
}
