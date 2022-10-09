package exercicio.alimentos;

public class Alimento {
	
	private String nome;
	private float valor;
	
	
	public Alimento(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
