
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
}
