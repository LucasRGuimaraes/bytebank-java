package br.com.factory;

public class Pizzaria {

	public static void main(String[] args) {
		
		PizzaEnum minhaPizza = PizzaEnum.CALABRESA;
		
		Pizza pizza = PizzaFactory.getPizza(minhaPizza);
		
		System.out.println(pizza);
	}
	
}
