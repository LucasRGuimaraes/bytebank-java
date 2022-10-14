package br.com.builder;

public class TestaCaneta {

	public static void main(String[] args) {

		Caneta canetaPobre = new Caneta.CanetaBuilder().setCorCorpo("Branco").setCorTampa("Preto").getCaneta();
		canetaPobre.imprimirCaneta();

		Caneta canetaRica = new Caneta.CanetaBuilder().setCorCorpo("Cinza").setCorTampa("Preto").getCaneta();
		canetaRica.imprimirCaneta();

	}

}
