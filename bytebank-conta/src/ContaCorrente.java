
public class ContaCorrente extends Conta implements Tributavel {
	
	public ContaCorrente (int agencia, int numero) {
		super(agencia, numero);
	}
	
	@Override
	public boolean sacar(double valor) {
		double valorAsacar = valor + 0.2;
		return super.sacar(valorAsacar);
	}

	@Override
	public void depositar(double valor) {
		super.saldo += valor;
	}

	@Override
	public double getValorImposto() {
		return super.saldo * 0.01;
	}
}
