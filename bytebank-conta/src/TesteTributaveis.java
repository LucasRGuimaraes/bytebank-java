
public class TesteTributaveis {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.depositar(100.0);
		
		SeguroVida seguro = new SeguroVida();
		CalculadorImposto calc = new CalculadorImposto();
		calc.regristra(cc);
		calc.regristra(seguro);
		
		System.out.println(calc.getTotalImposto());
	}
}
