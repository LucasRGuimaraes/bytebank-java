package br.com.exercicios29;

public class ConversorBinarioDecimal {

	public static void main(String[] args) {
		
		String binario = "11001";
		Integer decimal = 0;
		
		binario = new StringBuilder(binario).reverse().toString();
		
		for (int i = 0; i < binario.length(); i++) {
			
			if(binario.charAt(i) != '0') {
				decimal = decimal + (int) Math.pow(2, i);
			}
		}		

		System.out.println(decimal);
	}
	
}
