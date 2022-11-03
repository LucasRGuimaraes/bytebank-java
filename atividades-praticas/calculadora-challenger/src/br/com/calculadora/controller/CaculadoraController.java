package br.com.calculadora.controller;

import br.com.calculadora.DTO.CalculadoraDTO;
import br.com.calculadora.service.CalculadoraService;
import br.com.calculadora.view.CalculadoraView;

public class CaculadoraController {
	
	public static void main(String[] args) {
		
		CalculadoraView view = new CalculadoraView();
		CalculadoraDTO calculadoraDTO = new CalculadoraDTO();
		CalculadoraService calculadoraService = new CalculadoraService();
		
		calculadoraDTO.setPrimeiroValor(view.pedirPrimeiroValor());
		calculadoraDTO.setOperacao(view.pedirTipoDeOperacao());
		calculadoraDTO.setSegundoValor(view.pedirSegundoValor());
		
		Integer resultado = calculadoraService.calculaPraMim(calculadoraDTO);
		
		view.imprimirResultado(resultado);
		
	}
	
}