
public class Curso {

	private String nome;
	private Integer quantidadeAlunos;

	public Curso(String nome, Integer quantidadeAlunos) {
		super();
		this.nome = nome;
		this.quantidadeAlunos = quantidadeAlunos;
	}

	public String getNome() {
		return nome;
	}

	public Integer getQuantidadeAlunos() {
		return quantidadeAlunos;
	}
}
