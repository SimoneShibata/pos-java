
public class Exercicios {

	public String tiraAcento(String string) {
		return string.replace('�', 'a')
						.replace('�', 'a')
						.replace('�', 'i')
						.replace('�', 'c');
		
	}

	public String primeiraLetra(String string) {
		return string.substring(0, 1);
	}

	public String acentuarAsLetrasADaPrimeiraPalavra(String string) {
		String primeiraPalavra = string.split(" ")[0];
		return string.replaceAll(primeiraPalavra, primeiraPalavra.replace('a', '�').replace('A', '�'));
	}
}
