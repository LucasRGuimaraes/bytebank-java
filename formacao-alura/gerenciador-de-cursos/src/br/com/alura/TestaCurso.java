package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Aula 1", 21));
		javaColecoes.adiciona(new Aula("bula 2", 15));
		javaColecoes.adiciona(new Aula("Aula 3", 10));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
		System.out.println(aulasImutaveis);
		
		List<Aula> aulasMutaveis = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulasMutaveis);
		System.out.println(aulasMutaveis);
		System.out.println(javaColecoes.getTempoTotal());
		System.out.println(javaColecoes);
	}
	
}
