import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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


public class Exercicios {

	public String tiraAcento(String string) {
		return string.replace('á', 'a')
						.replace('ã', 'a')
						.replace('í', 'i')
						.replace('ç', 'c');
		
	}

	public String primeiraLetra(String string) {
		return string.substring(0, 1);
	}

	public String acentuarAsLetrasADaPrimeiraPalavra(String string) {
		String primeiraPalavra = string.split(" ")[0];
		return string.replaceAll(primeiraPalavra, primeiraPalavra.replace('a', 'á').replace('A', 'Á'));
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
		List<String> cidades = Arrays.asList("Maringá", "Mandaguari", "Araruna", "São Jorge do Ivaí");

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
	
}
