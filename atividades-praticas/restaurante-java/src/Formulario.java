import alimentos.Cafe;
import alimentos.ContraFile;
import alimentos.Frango;
import alimentos.Ovo;
import alimentos.Pao;
import alimentos.Picanha;

public class Formulario {

	public static void main(String[] args) {

		Cardapio cardapio = new Cardapio();
		Refeicao cafeDaManha = new Refeicao("Cafe da Manha");
		
		cardapio.adicionarRefeicao(cafeDaManha);
		cafeDaManha.adicionarAlimento(new Ovo());
		cafeDaManha.adicionarAlimento(new Pao());
		cafeDaManha.adicionarAlimento(new Cafe());
		
		Refeicao almoco = new Refeicao("Almoço");
		
		cardapio.adicionarRefeicao(almoco);
		almoco.adicionarAlimento(new Picanha());
		almoco.adicionarAlimento(new Frango());
		almoco.adicionarAlimento(new ContraFile());
		
		
		
		
		
		
		
		
		
		
		
		
		
		cardapio.imprimeCardapio();

	}

}
