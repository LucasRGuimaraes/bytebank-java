
public class TestaBanco {
	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Lucas");
		cliente.setCpf("122.094.857-89");
		cliente.setProfissao("estagiario nao remunerado");
		
		Conta conta = new Conta(1448, 26508);
		
		
		conta.setTitular(cliente);
		
		System.out.println(conta.getTitular().getNome());
	}
}
