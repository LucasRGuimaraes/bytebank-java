package br.com.alura;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		Set<String> alunos = new HashSet<>();
		
		alunos.add("Lucas");
		alunos.add("Thiago");
		alunos.add("Joao");
		alunos.add("Marcos");
		
		System.out.println(alunos);
		
		alunos.forEach(aluno -> {
			System.out.println(aluno);
		});
		
		List<String> alunosEmLista = new ArrayList<>(alunos);
		
	}
	
}
