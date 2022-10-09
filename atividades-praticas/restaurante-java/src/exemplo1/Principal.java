package exemplo1;

public class Principal {
	public static void main(String[] args) {
		PessoaBuilder pessoaBuilder = new PessoaBuilder();
		pessoaBuilder.setIdade(22).setNome("Lucas").setSaldoBancario(1500.50f);
	}
}
