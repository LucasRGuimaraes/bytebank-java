
public class TesteFuncionario {
	public static void main(String[] args) {
		
		Funcionario lucas = new Gerente();
		
		lucas.setNome("Lucas");
		lucas.setCpf("145.567.895-46");
		lucas.setSalario(50000.0);
		
		System.out.println(lucas.getNome());
		System.out.println(lucas.getBonificacao());
	}
}
