package br.com.calculadora.service;

import br.com.calculadora.DTO.CalculadoraDTO;
import br.com.calculadora.exception.OperacaoInvalida;

public class CalculadoraService {

	public Integer calculaPraMim(CalculadoraDTO calculadoraDTO) {
		
		Integer primeiroValor = calculadoraDTO.getPrimeiroValor();
		Integer segundoValor = calculadoraDTO.getSegundoValor();
		char operacao = calculadoraDTO.getOperacao();
		
		switch (operacao) {
			case '+': return this.somar(primeiroValor, segundoValor);
			case '-': return this.subtrair(primeiroValor, segundoValor);
			case '*': return this.multiplicar(primeiroValor, segundoValor);
			case '/': return this.dividir(primeiroValor, segundoValor);
			default: throw new OperacaoInvalida("Operação Invalida!");
		}
	}

	private Integer somar(Integer primeiroValor, Integer segundoValor) {
		return primeiroValor + segundoValor;
	}
	
	private Integer subtrair(Integer primeiroValor, Integer segundoValor) {
		return primeiroValor - segundoValor;
	}
	
	private Integer multiplicar(Integer primeiroValor, Integer segundoValor) {
		return primeiroValor * segundoValor;
	}
	
	private Integer dividir(Integer primeiroValor, Integer segundoValor) {
		return primeiroValor / segundoValor;
	}

}
