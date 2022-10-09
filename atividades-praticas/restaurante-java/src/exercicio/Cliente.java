package exercicio;

import exercicio.alimentos.AlimentoBuilder;
import exercicio.alimentos.Ovo;

public class Cliente {
	
	public static void main(String[] args) {
		AlimentoBuilder alimento = new AlimentoBuilder(new Ovo()).setValor(5.50f);
		System.out.println(alimento.getAlimento().getValor());
	}

}
