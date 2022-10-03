
public class TesteSaca {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(222, 333);
		conta.depositar(200.0);
		
		
		try {
			conta.sacar(200);
			
		} catch(SaldoInsuficienteException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		
		System.out.println(conta.getSaldo());
	}
}
