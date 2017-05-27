import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercicios {

	public String tiraAcento(String string) {
		return string.replace('á', 'a').replace('ã', 'a').replace('í', 'i')
				.replace('ç', 'c');

	}

	public String primeiraLetra(String string) {
		return string.substring(0, 1);
	}

	public String acentuarAsLetrasADaPrimeiraPalavra(String string) {
		String primeiraPalavra = string.split(" ")[0];
		return string.replaceAll(primeiraPalavra,
				primeiraPalavra.replace('a', 'á').replace('A', 'Á'));
	}

	public String[] separarFrases(String string, String separador) {
		return string.split(separador);
	}

	public Boolean contemValorNoArquivo(String string) {
		return deserializar(string);
	}

	private static boolean deserializar(String textoAProcurar) {
		try {
			InputStream file = new FileInputStream("comandos.txt");
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			try {
				List<String> lista = (List<String>) input.readObject();
				return lista.contains(textoAProcurar);
			} finally {
				input.close();
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Erro: " + ex);
		} catch (IOException ex) {
			System.out.println("Erro: " + ex);
		}
		return false;
	}

	public void criaArquivoCidade() {
		List<String> cidades = Arrays.asList("Maringá", "Mandaguari",
				"Araruna", "São Jorge do Ivaí");

		try {
			PrintStream novoArquivo = new PrintStream("cidades.txt");
			for (String cidadeSelecionada : cidades) {
				novoArquivo.println(cidadeSelecionada);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void lerArquivoCidades() {
		try {
			Scanner s = new Scanner(Paths.get("cidades.txt"));

			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Pessoa> exemploColecoes() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		pessoas.add(new Pessoa("Laís", 23));
		pessoas.add(new Pessoa("Yukie", 59));
		pessoas.add(new Pessoa("Belinha", 13));
		pessoas.add(new Pessoa("Belinha", 13));
		System.out.println(pessoas);

		Collections.sort(pessoas);
		return pessoas;
	}

	public List<String> ordernarString() {
		List<String> palavras = Arrays.asList("Lais", "Yukie", "Belinha", "Armando");
		Collections.sort(palavras);
		return palavras;
	}

	public String buscarCidade(String cidade) {
		List<String> cidades = Arrays.asList("Maringá", "Londrina", "Cambará");
		return cidades.stream().filter(c -> c.equals(cidade)).findFirst().orElse(null);
	}
	
}
