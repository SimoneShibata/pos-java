import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Executador {

	public static void main(String[] args) {

		// exemploEnumAntiPadrao();

		// lerDoTeclado();

		// trabalhandoComStrings();

		// stringComReplace();

		// inputOutputJava6();

		// inputOutputJava7();

		// inputOutputJava7Exemplo2();
	}

	private static void inputOutputJava7Exemplo2() {
		Path path = Paths.get("teste.txt");
		try {
			PrintStream novoArquivo = new PrintStream("saida.txt");
			try (Scanner scanner = new Scanner(path)) {
				while (scanner.hasNextLine()) {
					String linha = scanner.nextLine();
					System.out.println(linha);
					novoArquivo.println(linha);
				}

			} catch (IOException e) {
				e.printStackTrace();

			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	private static void inputOutputJava7() {
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(
				"novoarquivo.txt"))) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(
					"comandosa1.txt"))) {
				String linha = bufferReader.readLine();
				while (linha != null) {
					System.out.println("Comando: " + linha);
					bw.write(linha);
					bw.newLine();
					linha = bufferReader.readLine();
				}
			}
		} catch (IOException ex) {
			System.out.println("Erro: " + ex);
		}

	}

	private static void inputOutputJava6() {
		List<String> comandos = Arrays.asList("cima", "baixo", "direita",
				"esquerda");

		serializarObjeto(comandos);
		deserializar();
	}

	private static void deserializar() {
		try {
			// use buffering
			InputStream file = new FileInputStream("comandos.txt");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			try {
				List<String> lista = (List<String>) input.readObject();
				for (String comando : lista) {
					System.out.println("Comando: " + comando);
				}
			} finally {
				input.close();
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro: " + ex);
		} catch (IOException ex) {
			System.out.println("Erro: " + ex);
		}
	}

	private static void serializarObjeto(List<String> comandos) {
		try {
			OutputStream file = new FileOutputStream("comandos.txt");
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			try {
				output.writeObject(comandos);
			} finally {
				output.close();
			}
		} catch (IOException ex) {
			System.out.println("Erro: " + ex);
		}
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
