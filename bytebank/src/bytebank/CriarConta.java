package bytebank;

public class CriarConta {
	public static void main(String[] args) {
		Conta contaDoPaulo  = new Conta();
		Conta contaDaMarcela = new Conta();
		contaDoPaulo.depositar(1500);
		contaDaMarcela.depositar(200);
		
		System.out.println(contaDoPaulo.saldo);
		System.out.println(contaDaMarcela.saldo);
		
		if(contaDoPaulo.transferir(15, contaDaMarcela)) {
			System.out.println("Transferencia realizada com sucesso!");
		} else {
			System.out.println("Não foi possivel realizar a transferencia!");
		}
		
		System.out.println(contaDoPaulo.saldo);
		System.out.println(contaDaMarcela.saldo);
		
		System.out.println(contaDoPaulo.titular);
	}
}
