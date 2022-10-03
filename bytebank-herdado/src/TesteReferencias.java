
public class TesteReferencias {
	public static void main(String[] args) {
		Gerente g1 = new Gerente();
		g1.setNome("Lucas");
		g1.setSalario(5000.0);
		
		Funcionario f1 = new EditorVideo();
		f1.setNome("Liviane");
		f1.setSalario(2000.0);
		
		EditorVideo e1 = new EditorVideo();
		e1.setNome("Joao");
		e1.setSalario(2700.0);
		
		ControleBonificacao controle = new ControleBonificacao();
		controle.registra(g1);
		controle.registra(f1);
		controle.registra(e1);
		
		System.out.println(controle.getSoma());
	}
}
