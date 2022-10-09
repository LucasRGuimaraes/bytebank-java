
import java.util.ArrayList;
import java.util.List;

import alimentos.Alimento;

public class Refeicao {
	
	private String nome;
	private List<Alimento> listaDeAlimentosDaRefeicao = new ArrayList<>();
	
	public Refeicao(String nome) {
		this.nome = nome;
	}
	
	public void adicionarAlimento(Alimento alimento){
		this.listaDeAlimentosDaRefeicao.add(alimento);
	}

	public String getNome() {
		return nome;
	}

	public List<Alimento> getListaDeAlimentosDaRefeicao() {
		return listaDeAlimentosDaRefeicao;
	}
	
	
}
