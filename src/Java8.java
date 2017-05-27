import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Java8 {

	public static void main(String[] args) {
		// ordernarString();

		// ordenarPorTamanhoString();

		stream();
	}

	private static void stream() {
		List<Pessoa> pessoas = new ArrayList<>();
		pessoas.add(new Pessoa("maria", 32));
		pessoas.add(new Pessoa("jose", 31));
		pessoas.add(new Pessoa("jesus", 1));
		pessoas.add(new Pessoa("pilatos", 36));

//		pessoas.sort(Comparator.comparing((Pessoa p) -> p.getIdade()));
		
		pessoas.sort(Comparator.comparing(Pessoa::getIdade));
		// pessoas.forEach(p -> System.out.println(p.getNome()));

		pessoas.stream().filter(p -> p.getIdade() >= 32)
				.forEach(p -> System.out.println(p.getNome()));

	}

	private static void ordernarString() {
		List<String> palavras = Arrays.asList("Fusca", "Wagner", "Ariane",
				"Mariah");
		Collections.sort(palavras);
		System.out.println(palavras);
		palavras.forEach(new ImprimeTexto());
		System.out.println("---------------");
		palavras.forEach(s -> {
			System.out.println(s);
		});
		System.out.println("---------------");
		palavras.forEach(System.out::println);
	}

	private static void ordenarPorTamanhoString() {
		List<String> palavras = Arrays.asList("Fuscaaaaaaaaaaaaaaa",
				"Wagnaaaaaaaaer", "Ariane", "Mariah");
		Comparator<String> comparadorPorTamanho = new ComparadorPorTamanho();
		// Collections.sort(palavras, comparadorPorTamanho);
		System.out.println(palavras);
		System.out.println("---------------");
		palavras.sort((String s1, String s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			}
			if (s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});
		System.out.println(palavras);
		System.out.println("---------------");
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		System.out.println("---------------");
		palavras.sort(Comparator.comparing(s -> s.length()));
		System.out.println(palavras);
		System.out.println("---------------");
		palavras.sort(Comparator.comparing(String::length)); // reference method
		System.out.println(palavras);
	}

}

class ImprimeTexto implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}
