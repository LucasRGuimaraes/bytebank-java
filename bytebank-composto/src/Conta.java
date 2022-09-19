public class Conta {
	
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total;
	
	public Conta(int agencia, int numero) {
		if (agencia > 0 && numero > 0) {
			this.agencia = agencia;
			this.numero = numero;	
		}
		Conta.total++;
	}
		
	public void depositar (double valorDoDeposito) {
		this.saldo += valorDoDeposito;
	}
	
	public boolean sacar (double valorDoSaque) {
		if (this.saldo >= valorDoSaque) {
			this.saldo -= valorDoSaque;
			return true;
		}
		return false;
	}
	
	public boolean transferir(double valorDaTransferencia, Conta contaDestino){
		if (this.saldo >= valorDaTransferencia) {
			this.sacar(valorDaTransferencia);
			contaDestino.depositar(valorDaTransferencia);
			return true;		
		}
		return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	
	public static int getTotal() {
		return Conta.total;
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getTitular() {
		return titular;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	
}
