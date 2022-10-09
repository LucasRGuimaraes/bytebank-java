package exemplo1;

public class PessoaBuilder {
	
	public Pessoa pessoa;
	
	public PessoaBuilder() {
		this.pessoa = new Pessoa();
	}
	
	public PessoaBuilder setNome(String nome) {
		pessoa.setNome(nome);
		return this;
	}
	
	public PessoaBuilder setIdade(int idade) {
		pessoa.setIdade(idade);
		return this;
	}
	
	public PessoaBuilder setSaldoBancario(float saldoBancario) {
		pessoa.setSaldoBancario(saldoBancario);
		return this;
	}
	
	public Pessoa getPessoa () {
		return pessoa;
	}
}
