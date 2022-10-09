package exemplo2;

public class CasaDeMadeiraBuilder implements CasaBuilder {
	
	private Casa casa;
	
	public CasaDeMadeiraBuilder() {
		this.casa = new Casa();
	}

	@Override
	public void buildPorao() {
		this.casa.setPorao("Porão de Madeira");
		
	}

	@Override
	public void buildEstrutura() {
		this.casa.setEstrutura("Estrutura de Madeira");
	}

	@Override
	public void buildTelhado() {
		this.casa.setTelhado("Telhado de Madeira");
	}

	@Override
	public void buildInterior() {
		this.casa.setInterior("Interior de Madeira");
	}

	@Override
	public Casa buildCasa() {
		return this.casa;
	}
	
}
