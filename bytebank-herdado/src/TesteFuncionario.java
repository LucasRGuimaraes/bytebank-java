
public class TesteFuncionario {
	public static void main(String[] args) {
		
		Funcionario lucas = new Funcionario();
		
		lucas.setNome("Lucas");
		lucas.setCpf("145.567.895-46");
		lucas.setSalario(50000.0);
		
		System.out.println(lucas.getNome());
		System.out.println(lucas.getBonificacao());
	}
}
