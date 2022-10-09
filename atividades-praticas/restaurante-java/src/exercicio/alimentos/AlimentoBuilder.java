package exercicio.alimentos;

public class AlimentoBuilder {
	
	private Alimento alimento;
	
	public AlimentoBuilder(Alimento alimento) {
		this.alimento = alimento;
	}
	
	public AlimentoBuilder setValor(float valor) {
		this.alimento.setValor(valor);
		return this;
	}
	
	public Alimento getAlimento() {
		return alimento;
	}
}
