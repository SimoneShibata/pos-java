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
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
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

		// copiarArquivo();

		// threads();

		// threadsSincronizada();

		performanceList();
		performanceLinkedList();
		performanceHashSet();
		performanceLinkedSet();
	}

	private static void performanceHashSet() {
		System.out.println("Iniciando Hashset...");
		Collection<Integer> teste = new HashSet<Integer>();
		percorrer(teste);

	}

	private static void performanceLinkedSet() {
		System.out.println("Iniciando LinkedHashSet...");
		Collection<Integer> teste = new LinkedHashSet<Integer>();
		percorrer(teste);

	}

	private static void performanceList() {
		System.out.println("Iniciando List...");
		Collection<Integer> teste = new ArrayList<Integer>();
		percorrer(teste);
	}

	private static void performanceLinkedList() {
		System.out.println("Iniciando LinkedList...");
		Collection<Integer> teste = new LinkedList<Integer>();
		percorrer(teste);
	}

	private static void percorrer(Collection<Integer> teste) {
		long inicio = System.currentTimeMillis();

		int total = 30000;

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}

		long fim = System.currentTimeMillis();
		long tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
	}
	
	/**
	 * Teste de Sincronismo de Threads
	 */
	private static void threadsSincronizada() {
		ClasseSynchronized sincronismo = new ClasseSynchronized();
		Thread t1 = new Thread(sincronismo);
		Thread t2 = new Thread(sincronismo);

		t1.start();
		t2.start();
	}

	/**
	 * Threads sem sincronismo
	 */
	private static void threads() {
		EscreveAlgo algo = new EscreveAlgo();
		EscreveOutraCoisa outraCoisa = new EscreveOutraCoisa();

		Thread t1 = new Thread(algo);
		Thread t2 = new Thread(outraCoisa);

		t1.start();
		t2.start();
	}

	private static void copiarArquivo() {
		Path FROM = Paths.get("saida.txt");
		Path TO = Paths.get("c:\\temp\\saida2.txt");

		CopyOption[] options = new CopyOption[] {
				StandardCopyOption.REPLACE_EXISTING,
				StandardCopyOption.COPY_ATTRIBUTES };

		try {
			Files.copy(FROM, TO, options);
		} catch (IOException e) {
			e.printStackTrace();
		}

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
		String texto = "Aula de s�bado do Fusca";
		System.out.println(texto.replace("a", "b"));
	}

	/**
	 * Melhores pr�ticas com String
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

		// good (mais r�pido)
		StringBuilder builder = new StringBuilder("primeira linha \n");
		builder.append("segunda linha \n");
		builder.append("terceira linha \n");

	}

	/**
	 * Melhores pr�ticas com Enum
	 */
	private static void exemploEnumAntiPadrao() {
		DiasSemana hoje = DiasSemana.SABADO;

		// bad
		if (hoje.equals(DiasSemana.SABADO)) {
			System.out.println("Hoje � s�bado!");
		}

		// good
		if (DiasSemana.SABADO.equals(hoje)) {
			System.out.println("Hoje � s�bado!");

		}
	}

	/**
	 * Como pedir inser��o de String e Int por console
	 */
	private static void lerDoTeclado() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Digite: ");
		String resposta = teclado.nextLine();
		System.out.println("Digitou: " + resposta);

		System.out.println("Digite um n�mero: ");
		Integer numero = teclado.nextInt();
		System.out.println("Digitou: " + numero);
	}

}
