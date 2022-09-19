package bytebank;

public class Conta {
	
	double saldo;
	int agencia;
	int numero;
	String titular;
		
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
}
