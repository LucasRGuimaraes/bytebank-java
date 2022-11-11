package br.com.exerciciosMarcos;

import java.util.ArrayList;
import java.util.List;

public class SomarArray {

	public static void main(String[] args) {

		SomarArray somarArray = new SomarArray();
		
		List<Integer> array = somarArray.inicializarArray(100000000);
		
		Long tempoInicial = System.currentTimeMillis();
		
//		Long somatoria = somarArray.somarArray1(array);   // 540ms resultado 5000000050000000
//		Long somatoria = somarArray.somarArray2(array);   // 520ms resultado 5000000050000000
//		Long somatoria = somarArray.somarArray3(array);   // 430ms resultado 5000000050000000
//		Long somatoria = somarArray.somarArray4(array);   // 505ms resultado 5000000050000000
		Long somatoria = somarArray.somarArray5(array);   // 000ms retultado 5000000050000000
		
		Long tempoFinal = System.currentTimeMillis();
		
		Long tempoOperacao = (tempoFinal - tempoInicial);
		
		System.out.println("Somatoria foi: " + somatoria );
		System.out.printf("Total de: %d milisegundos", tempoOperacao);
		
	}
	
	
	// INICIALIZAR ARRAY
	public List<Integer> inicializarArray(Integer n) {
		List<Integer> array = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
		
		return array;
	}

	
	// PRIMEIRO METODO - SOMA SEQUENCIALMENTE DO PRIMEIRO AO ULTIMO
	public Long somarArray1(List<Integer> array) {
		Long somatoria = 0l;
		
		for (int i = 0; i < array.size(); i++) {
			somatoria = somatoria + array.get(i);
		}
		
		return somatoria;
	}
	
	
	// SEGUNDO METODO - SOMA A PRIMEIRA METADE E DEPOIS A SEGUNDA METADE
	public Long somarArray2(List<Integer> array) {
		Long somatoria = 0l;
		
		Integer metade = array.size() / 2;
		
		for (int i = 0; i < metade; i++) {
			somatoria = somatoria + array.get(i);
		}
		
		for (int i = metade; i < array.size(); i++) {
			somatoria = somatoria + array.get(i);
		}
		
		return somatoria;
	}
	
	
	// TERCEIRO METODO - SOMA O PRIMEIRO COM O ULTIMO, SEGUNDO COM O PENULTIMO, ASSIM POR DIANTE
	public Long somarArray3(List<Integer> array) {
		Integer ultimoValor = array.size();
		Integer primeiroValor = array.get(0);
		Long somatoria = 0l;
		
		for (int i = 1; i <= array.size() / 2; i++) {
			somatoria = somatoria + primeiroValor + ultimoValor;
			primeiroValor++;
			ultimoValor--;
		}
		
		return somatoria;
	}
	
	
	// QUARTO METODO - SOMA SEQUENCIALEMENTE DO ULTIMO AO PRIMEIRO
	public Long somarArray4(List<Integer> array) {
		Long somatoria = 0l;
		
		for (int i = array.size() - 1; i >=  0; i--) {
			somatoria = somatoria + array.get(i);
		}
		
		return somatoria;
	}
	
	
	// QUINTO METODO
	public Long somarArray5(List<Integer> array) {
		Long somatoria = 0l;
		
		Integer primeiroValor = array.get(0);
		Integer ultimoValor = array.get(array.size() - 1);
		
		somatoria = (long) (array.size() / 2) * (primeiroValor + ultimoValor);
		
		return somatoria;
	}
	

}
