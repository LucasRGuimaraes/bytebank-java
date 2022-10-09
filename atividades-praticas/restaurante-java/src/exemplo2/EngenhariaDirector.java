package exemplo2;

public class EngenhariaDirector {
	
	private CasaBuilder casaBuilder;
	
	public EngenhariaDirector(CasaBuilder casaBuilder) {
		this.casaBuilder = casaBuilder;
	}
	
	public Casa getCasa() {
		return this.casaBuilder.buildCasa();
	}
	
	public void construirCasa() {
		this.casaBuilder.buildPorao();
		this.casaBuilder.buildEstrutura();
		this.casaBuilder.buildTelhado();
		this.casaBuilder.buildInterior();
	}

}
