package alimentos;

public class ContraFile extends Alimento {

	public ContraFile() {
		this.nome = "ContraFile";
		this.valor = 25.00f;
	}
	@Override
	public void setValor(Float valor) {
		this.valor = valor;
	}
}
