package alimentos;

public class Pao extends Alimento {

	public Pao() {
		this.nome = "Pao";
		this.valor = 5.00f;
	}

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
