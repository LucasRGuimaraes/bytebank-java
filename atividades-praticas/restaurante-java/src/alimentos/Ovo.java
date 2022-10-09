package alimentos;

public class Ovo extends Alimento {
	
	public Ovo() {
		this.nome = "Ovo";
		this.valor = 5.00f;
	}

	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
