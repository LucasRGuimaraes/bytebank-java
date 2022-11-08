package br.com.exercicios29;

public class NessimoNumeroPrimo {

	public static void main(String[] args) {
		
		Integer nessimo = 5;
		Integer qntdPrimos = 3;
		Integer numero = 2;
		
		while (qntdPrimos < nessimo) {
			
			if(numero % 2 != 0 && numero % 3 != 0 && numero % 5 != 0) {
				qntdPrimos++;
			}
			
			if(qntdPrimos == nessimo) {
				System.out.println(numero);
			}
			
			numero++;
			
			
		}
		
	}
	
}
