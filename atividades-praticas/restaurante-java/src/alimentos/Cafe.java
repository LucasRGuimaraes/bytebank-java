package alimentos;

public class Cafe extends Alimento {

	public Cafe() {
		this.nome = "Cafe";
		this.valor = 5.00f;
	}
	

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
