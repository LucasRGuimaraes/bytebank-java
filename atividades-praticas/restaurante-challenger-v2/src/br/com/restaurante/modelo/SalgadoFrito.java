package br.com.restaurante.modelo;

public class SalgadoFrito extends Produto {

	public SalgadoFrito(Integer id, String nome, Double valor) {
		super(id, nome, valor);
	}

	@Override
	public String toString() {
		return String.format("%10s%20s%10s%20s", super.getId(), "SALGADO FRITO", super.getNome(), super.getValor());
	}

}
