
public class TesteGerente {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		
		gerente.setNome("Claudio");
		gerente.setCpf("125.487.896-45");
		gerente.setSalario(6500.0);
		
		gerente.setSenha(11454);
		
		System.out.println(gerente.autentica(11453));
		
		System.out.println(gerente.getBonificacao());
	}
}
