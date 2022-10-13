package br.com.alura;

public class TestaBuscaAlunosNoCurso {

	public static void main(String[] args) {
		Curso cursoJavaColecoes = new Curso("Dominando as coleções do Java", "Paulo Silveira");

		cursoJavaColecoes.adiciona(new Aula("Aula 1", 21));
		cursoJavaColecoes.adiciona(new Aula("bula 2", 15));
		cursoJavaColecoes.adiciona(new Aula("Aula 3", 10));
		
		Aluno a1 = new Aluno("Rodrigo Turini", 34672);
		Aluno a2 = new Aluno("Lucas Guimaraes", 54236);
		Aluno a3 = new Aluno("Joao Turri", 78324);
		
		cursoJavaColecoes.matricula(a1);
		cursoJavaColecoes.matricula(a2);
		cursoJavaColecoes.matricula(a3);
		
		System.out.println("Quem é o aluno com matricula 54236?");
		Aluno aluno = cursoJavaColecoes.buscaAlunoPorMatricula(54236);
		System.out.println("Aluno: " + aluno);
		
		cursoJavaColecoes.getMatriculaParaAluno().forEach(value -> System.out.println(value));
	}
	
}
