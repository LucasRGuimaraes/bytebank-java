package exemplo2;

public class Cliente {
	public static void main(String[] args) {
//		CasaBuilder casaBuilder = new CasaDeMadeiraBuilder();
		CasaBuilder casaBuilder = new CasaDeConcretoBuilder();
		
		
		EngenhariaDirector engenharia = new EngenhariaDirector(casaBuilder);
		engenharia.construirCasa();
		
		Casa casa = engenharia.getCasa();
		
		System.out.println("Casa construida:" + casa);
		
		
		
	}
}
