package br.com.builder;

public class Caneta {

	private String corCorpo;
	private String corTampa;

	private Caneta(String corCorpo, String corTampa) {
		super();
		this.corCorpo = corCorpo;
		this.corTampa = corTampa;
	}

	public String getCorCorpo() {
		return corCorpo;
	}

	public String getCorTampa() {
		return corTampa;
	}

	public void imprimirCaneta() {
		System.out.println("A caneta tem corpo da cor " + this.getCorCorpo() + " e tampa da cor " + this.getCorTampa());
	}

	static class CanetaBuilder {

		private String corCorpo;
		private String corTampa;

		public CanetaBuilder setCorCorpo(String corCorpo) {
			this.corCorpo = corCorpo;
			return this;
		}
		
		public CanetaBuilder setCorTampa(String corTampa) {
			this.corTampa = corTampa;
			return this;
		}
		
		public Caneta getCaneta() {
			return new Caneta(this.corCorpo, this.corTampa);
		}
	}
}
