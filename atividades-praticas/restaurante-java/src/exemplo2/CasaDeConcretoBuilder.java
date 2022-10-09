package exemplo2;

public class CasaDeConcretoBuilder implements CasaBuilder {
	
	private Casa casa;
	
	public CasaDeConcretoBuilder() {
		this.casa = new Casa();
	}

	@Override
	public void buildPorao() {
		this.casa.setPorao("Porão de Concreto");
		
	}

	@Override
	public void buildEstrutura() {
		this.casa.setEstrutura("Estrutura de Concreto");
	}

	@Override
	public void buildTelhado() {
		this.casa.setTelhado("Telhado de Concreto");
	}

	@Override
	public void buildInterior() {
		this.casa.setInterior("Interior de Concreto");
	}

	@Override
	public Casa buildCasa() {
		return this.casa;
	}
	
}
