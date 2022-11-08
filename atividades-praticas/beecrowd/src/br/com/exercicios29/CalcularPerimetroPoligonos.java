package br.com.exercicios29;

import java.util.Scanner;

public class CalcularPerimetroPoligonos {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Quantos vertices seu poligono possui?");
		Integer qntdVertices = scanner.nextInt();
		Integer perimetro = 0;
		
		for (int i = 0; i < qntdVertices; i++) {
			System.out.println("Qual o tamanho do vertice " + (i + 1) + "?");
			perimetro = perimetro + scanner.nextInt();
		}
		
		System.out.println(perimetro);
		
	}

}
