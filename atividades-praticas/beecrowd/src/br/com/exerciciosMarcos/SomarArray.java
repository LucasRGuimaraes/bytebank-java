package br.com.exerciciosMarcos;

import java.util.ArrayList;
import java.util.List;

public class SomarArray {

	public static void main(String[] args) {

		SomarArray somarArray = new SomarArray();
		
		List<Integer> array = somarArray.inicializarArray(100000000);
		
		Long tempoInicial = System.currentTimeMillis();
		
//		Long somatoria = somarArray.somarArray1(array);   // 580ms resultado 5000000050000000
		Long somatoria = somarArray.somarArray2(array);   //                   2500000100000000
//		Long somatoria = somarArray.somar3(array);
		
		Long tempoFinal = System.currentTimeMillis();
		
		Long tempoOperacao = (tempoFinal - tempoInicial) / 1000;
		
		System.out.println("Somatoria foi: " + somatoria );
		System.out.printf("Em um total de: %,d", tempoOperacao);
		
		
	}
	
	public List<Integer> inicializarArray(Integer n) {
		List<Integer> array = new ArrayList<>();
		
		for (int i = 1; i <= n; i++) {
			array.add(i);
		}
		
		return array;
	}
	
	public Long somarArray1(List<Integer> array) {
		Long somatoria = 0l;
		
		for (int i = 0; i < array.size(); i++) {
			somatoria = somatoria + array.get(i);
		}
		
		return somatoria;
	}
	
	public Long somarArray2(List<Integer> array) {
		Long somatoria = 0l;
		
		Integer metade = array.size() / 2;
		
		for (int i = 0; i < metade / 2; i++) {
			somatoria = somatoria + array.get(i);
		}
		
		for (int i = metade; i < array.size(); i++) {
			somatoria = somatoria + array.get(i);
		}
		
		return somatoria;
	}

}
