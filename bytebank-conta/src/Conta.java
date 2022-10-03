
public abstract class Conta {

	protected double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;

	public Conta(int agencia, int numero) {
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
	}

	public abstract void depositar(double valor);

	public boolean sacar(double valorSacar) {
		if (this.saldo >= valorSacar) {
			this.saldo -= valorSacar;
			return true;
		} else {
			return false;
		}

	}

}
