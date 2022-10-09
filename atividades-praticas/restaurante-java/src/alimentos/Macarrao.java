package alimentos;

public class Macarrao extends Alimento {

	public Macarrao() {
		this.nome = "Macarrao";
		this.valor = 5.00f;
	}

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
