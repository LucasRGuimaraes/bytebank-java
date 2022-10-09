package br.com.bytebank.banco.modelo;

public class GuardadorDeContas {

	
	private Object[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeContas() {
		this.referencias = new Object[10];
		this.posicaoLivre = 0;
	}
	
	public void adiciona(Object conta) {
		this.referencias[this.posicaoLivre] = conta;
		this.posicaoLivre++;
	}

	public int getQuantidadeDeElementos() {
		return posicaoLivre;
	}

	public Object getReferencia(int posicao) {
		return this.referencias[posicao];
	}
}
