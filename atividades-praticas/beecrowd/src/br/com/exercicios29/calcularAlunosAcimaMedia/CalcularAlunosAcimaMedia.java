package br.com.exercicios29.calcularAlunosAcimaMedia;

import java.util.ArrayList;
import java.util.List;

public class CalcularAlunosAcimaMedia {

	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<>();
		Double somatoriaMediaAluno = 0d;
		Double mediaTurma = 0d;
		
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 8.0, 7.0));
		alunos.add(new Aluno("Lucas", 9.0, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		alunos.add(new Aluno("Lucas", 7.5, 7.0));
		
		System.out.println(alunos);
		
		for (int i = 0; i < alunos.size(); i++) {
			somatoriaMediaAluno += alunos.get(i).calcularMedia();
		}
		
		mediaTurma = somatoriaMediaAluno / alunos.size();
		
		for (int i = 0; i < alunos.size(); i++) {
			Aluno aluno = alunos.get(i);
			
			if(aluno.calcularMedia() > mediaTurma) {
				System.out.printf(aluno + " está com a média %.2f, ou seja, acima da média da turma de: %.2f \n" , aluno.calcularMedia(), mediaTurma);
			}
		}
		
		
	}
	
}
