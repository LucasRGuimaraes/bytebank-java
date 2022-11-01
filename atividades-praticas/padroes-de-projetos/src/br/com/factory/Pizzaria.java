package br.com.factory;

public class Pizzaria {

	public static void main(String[] args) {

		PizzaEnum minhapizza = PizzaEnum.CALABRESA;

		Pizza pizza = PizzaFactory.getPizza(minhapizza);

		System.out.println(pizza);
	}

}
