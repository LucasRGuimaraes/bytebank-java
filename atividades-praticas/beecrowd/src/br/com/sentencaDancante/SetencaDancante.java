package br.com.sentencaDancante;

public class SetencaDancante {

	public static void main(String[] args) {

		String frase = "This   is         a  dancing   sentence";
		String novaFrase = null;
		
		
		for (int i = 0; i < frase.length(); i++) {

			int contador = 0;
			
			if(frase.charAt(i) != ' ') {
				
				if(contador % 2 == 0) {
					novaFrase += Character.toUpperCase(frase.charAt(i));
				}
				
				if(contador % 2 == 1) {
					novaFrase += Character.toLowerCase(frase.charAt(i));
				}
				
				contador++;
				
			}
			
			
			
		}
		
		System.out.println(frase);
		
	}

}
