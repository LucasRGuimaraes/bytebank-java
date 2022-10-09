package alimentos;

public class Frango extends Alimento {

	public Frango() {
		this.nome = "Frango";
		this.valor = 22.50f;
	}
	
	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
