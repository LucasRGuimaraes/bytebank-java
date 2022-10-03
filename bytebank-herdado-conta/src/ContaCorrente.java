
public class ContaCorrente extends Conta {
	
	
	public ContaCorrente(int agencia, int numero) {
		super(agencia, numero);
	}
	
	
	@Override
	public void sacar(double valorDoSaque) throws SaldoInsuficienteException {
		double valorDoSaqueNaContaCorrente = valorDoSaque + 0.2;
		super.sacar(valorDoSaqueNaContaCorrente);
	}
}
