public abstract class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	private Cliente titular;
	private static int total = 0;
	
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
	
	public void sacar (double valorDoSaque) throws SaldoInsuficienteException {
		if (this.saldo <= valorDoSaque) {
			throw new SaldoInsuficienteException("Saldo: " + this.saldo + ", valor a sacar:" + valorDoSaque);
		}
		this.saldo -= valorDoSaque;
	}
	
	public void transferir(double valorDaTransferencia, Conta contaDestino) throws SaldoInsuficienteException{
		this.sacar(valorDaTransferencia);
		contaDestino.depositar(valorDaTransferencia);
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
