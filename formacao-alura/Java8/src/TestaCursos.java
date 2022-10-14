import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestaCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C++", 55));

		cursos.sort(Comparator.comparing(Curso::getQuantidadeAlunos));
//		cursos.forEach(c -> System.out.println(c.getNome()));

		int sum = cursos.stream().filter(c -> c.getQuantidadeAlunos() >= 100).mapToInt(Curso::getQuantidadeAlunos)
				.sum();
		System.out.println(sum);

		cursos.stream().filter(c -> c.getQuantidadeAlunos() >= 100).findAny()
				.ifPresent(c -> System.out.println(c.getNome()));
		
		List<Curso> resultadoFiltro = cursos.stream().filter(c -> c.getQuantidadeAlunos() >= 100).collect(Collectors.toList());

	}

}