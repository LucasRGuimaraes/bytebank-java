
public class TesteSemCliente {
	public static void main(String[] args) {
		Conta contaDaLiviane = new Conta(1448, 11503);
		Conta conta2 = new Conta(1448, 11503);
		Conta conta3 = new Conta(1448, 11503);
		System.out.println(contaDaLiviane.getSaldo());
		
		contaDaLiviane.setTitular(new Cliente());
		System.out.println(contaDaLiviane.getTitular().getNome());
		
		contaDaLiviane.getTitular().setNome("Liviane");
		System.out.println(contaDaLiviane.getTitular().getNome());
		
		System.out.println(Conta.getTotal());
	}
}
