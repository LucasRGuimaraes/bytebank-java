package br.com.restaurante.modelo;

public class SalgadoAssado extends Produto {

	public SalgadoAssado(int id, String nome, double valor) {
		super(id, nome, valor);
	}

	@Override
	public String toString() {
		return String.format("%10s%20s%10s%10s", super.getId(), "SALGADO ASSADO", super.getNome(), super.getValor());
	}

}
