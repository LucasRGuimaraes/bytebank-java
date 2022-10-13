package br.com.alura;

public class Aluno {

	private String nome;
	private Integer numeroMatricula;

	public Aluno(String nome, Integer numeroMatricula) {
		if (nome == null) {
			throw new NullPointerException("Nome não pode ser null!");
		}

		this.nome = nome;
		this.numeroMatricula = numeroMatricula;
	}

	public String getNome() {
		return nome;
	}

	public Integer getNumeroMatricula() {
		return numeroMatricula;
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Aluno outroAluno = (Aluno) obj;
		return this.nome.equals(outroAluno.nome) && this.numeroMatricula.equals(outroAluno.numeroMatricula);
	}

	@Override
	public String toString() {
		return "Aluno: " + this.nome + ", numeroMatricula: " + this.numeroMatricula;
	}

}
