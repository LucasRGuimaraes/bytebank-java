package alimentos;

public abstract class Alimento {
	
	protected String nome;
	protected Float valor;
	
	public String getNome() {
		return nome;
	}

	public Float getValor() {
		return valor;
	}

	public abstract void setValor(Float valor);
	
}
