package br.com.restaurante.modelo;

public class Teste {
	
	public enum Day { SUNDAY, MONDAY, TUESDAY,
	    WEDNESDAY, THURSDAY, FRIDAY, SATURDAY; }

	public static void main(String[] args) {
		Day day = Day.SUNDAY;    
	    System.out.println(
	        switch (day) {
	            case MONDAY, FRIDAY, SUNDAY -> 6;
	            case TUESDAY                -> 7;
	            case THURSDAY, SATURDAY     -> 8;
	            case WEDNESDAY              -> 9;
	            default -> throw new IllegalStateException("Invalid day: " + day);
	        }
	    );    
	}
}
