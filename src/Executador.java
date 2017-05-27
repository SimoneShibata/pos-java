import java.util.Scanner;

public class Executador {

	public static void main(String[] args) {

		// exemploEnumAntiPadrao();

		// lerDoTeclado();

		// trabalhandoComStrings();

		stringComReplace();

	}

	private static void stringComReplace() {
		String texto = "Aula de sábado do Fusca";
		System.out.println(texto.replace("a", "b"));
	}

	/**
	 * Melhores práticas com String
	 */
	private static void trabalhandoComStrings() {
		// bad
		String texto = new String();
		Integer inteiro = new Integer(12);
		Integer inteiro2 = new Integer(12);

		// good
		Integer inteiro3 = 12;

		// bad
		String concatenacao = "primeira linha \n";
		concatenacao = concatenacao + "segunda linha \n";
		concatenacao = concatenacao + "terceira linha \n";

		// good
		StringBuffer buffer = new StringBuffer("primeira linha \n");
		buffer.append("segunda linha \n");
		buffer.append("terceira linha \n");

		// good (mais rápido)
		StringBuilder builder = new StringBuilder("primeira linha \n");
		builder.append("segunda linha \n");
		builder.append("terceira linha \n");

	}

	/**
	 * Melhores práticas com Enum
	 */
	private static void exemploEnumAntiPadrao() {
		DiasSemana hoje = DiasSemana.SABADO;

		// bad
		if (hoje.equals(DiasSemana.SABADO)) {
			System.out.println("Hoje é sábado!");
		}

		// good
		if (DiasSemana.SABADO.equals(hoje)) {
			System.out.println("Hoje é sábado!");

		}
	}

	/**
	 * Como pedir inserção de String e Int por console
	 */
	private static void lerDoTeclado() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite: ");
		String resposta = teclado.nextLine();
		System.out.println("Digitou: " + resposta);

		System.out.println("Digite um número: ");
		Integer numero = teclado.nextInt();
		System.out.println("Digitou: " + numero);
	}

}
