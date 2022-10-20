package br.com.restaurante.modelo;

public class SalgadoAssado extends Produto {

	public SalgadoAssado(Integer id, String nome, Double valor) {
		super(id, nome, valor);
	}

	@Override
	public String toString() {
		return String.format("%10s%20s%10s%20s", super.getId(), "SALGADO ASSADO", super.getNome(), super.getValor());
	}

}
