import java.util.ArrayList;
import java.util.List;

import alimentos.Alimento;

public class Cardapio {
	
	private List<Refeicao> cardapio = new ArrayList<>();
	
	public void adicionarRefeicao(Refeicao refeicao) {
		this.cardapio.add(refeicao);
	}

	public void imprimeCardapio() {
		System.out.println("Cardapio");
		
		for (Refeicao refeicao : cardapio) {
			System.out.println(refeicao.getNome());
			
			Float total = 0f;
			for (Alimento alimento : refeicao.getListaDeAlimentosDaRefeicao()) {
				System.out.println(alimento.getNome());
				total += alimento.getValor();
			}
			System.out.println(total);
		}
	}

	
}
