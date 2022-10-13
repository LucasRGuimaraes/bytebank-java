package br.com.alura;

public class TestaCursoComAluno {

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
		
		System.out.println("Todos os alunos matriculados:");
		cursoJavaColecoes.getAlunos().forEach(aluno -> System.out.println(aluno));
		
		System.out.println("O aluno " + a1 + " está matriculado?");
		System.out.println(cursoJavaColecoes.estaMatriculado(a1));
		
		Aluno turini = new Aluno("Rodrigo Turini", 34672);
		System.out.println("E esse Turini, está matriculado?");
		System.out.println(cursoJavaColecoes.estaMatriculado(turini));
		
		
		System.out.println("O a1 é equals ao Turini?");
		System.out.println(a1.equals(turini));
		
		// O brigatoriamente o seguinte é true:
		
		System.out.println(a1.hashCode() == turini.hashCode());
		
	}

}
