package alimentos;

public class Pizza extends Alimento {

	public Pizza() {
		this.nome = "Pizza";
		this.valor = 5.00f;
	}

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
