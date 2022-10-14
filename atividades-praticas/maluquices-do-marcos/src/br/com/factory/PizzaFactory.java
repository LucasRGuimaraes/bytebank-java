package br.com.factory;

public class PizzaFactory {
	
	private PizzaFactory() {}

	public static Pizza getPizza(PizzaEnum nomePizza) {
		
		switch (nomePizza) {
		case CALABRESA: {
			return new PizzaCalabresa();
		}
		case AZEITONA: {
			return new PizzaAzeitona();
		}
		default:
			return null;
		}
		
	}
	
}
