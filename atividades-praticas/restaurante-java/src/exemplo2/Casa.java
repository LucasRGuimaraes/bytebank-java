package exemplo2;

public class Casa implements CasaPlanejamento {
	
	private String porao;
	private String estrutura;
	private String telhado;
	private String interior;

	@Override
	public void setPorao(String porao) {
		this.porao = porao;
	}

	@Override
	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}

	@Override
	public void setTelhado(String telhado) {
		this.telhado = telhado;
	}

	@Override
	public void setInterior(String interior) {
		this.interior = interior;
	}

	@Override
	public String toString() {
		return "Casa [porao=" + porao + ", estrutura=" + estrutura + ", telhado=" + telhado + ", interior=" + interior
				+ "]";
	}
	
}
