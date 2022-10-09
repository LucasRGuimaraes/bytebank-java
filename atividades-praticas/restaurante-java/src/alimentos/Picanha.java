package alimentos;

public class Picanha extends Alimento {

	public Picanha() {
		this.nome = "Picanha";
		this.valor = 29.00f;
	}

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
