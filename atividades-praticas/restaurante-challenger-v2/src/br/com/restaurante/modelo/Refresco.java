package br.com.restaurante.modelo;

public class Refresco extends Produto {

	public Refresco(Integer id, String nome, Double valor) {
		super(id, nome, valor);
	}

	@Override
	public String toString() {
		return String.format("%10s%20s%10s%20s", super.getId(), "REFRESCO", super.getNome(), super.getValor());
	}

}
