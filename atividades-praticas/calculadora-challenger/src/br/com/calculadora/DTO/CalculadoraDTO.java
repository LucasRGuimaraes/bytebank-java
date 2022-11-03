package br.com.calculadora.DTO;

public class CalculadoraDTO {

	private Integer primeiroValor;
	private Integer segundoValor;
	private char operacao;

	public Integer getPrimeiroValor() {
		return primeiroValor;
	}

	public void setPrimeiroValor(Integer primeiroValor) {
		this.primeiroValor = primeiroValor;
	}

	public Integer getSegundoValor() {
		return segundoValor;
	}

	public void setSegundoValor(Integer segundoValor) {
		this.segundoValor = segundoValor;
	}

	public char getOperacao() {
		return operacao;
	}

	public void setOperacao(char operacao) {
		this.operacao = operacao;
	}

}
