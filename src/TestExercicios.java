import static org.junit.Assert.*;

import org.junit.Test;


public class TestExercicios {

	@Test
	public void testTiraAcento() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.tiraAcento("Manuten��o"), "Manutencao");
		assertEquals(exercicios.tiraAcento("Paran�"), "Parana");
		assertEquals(exercicios.tiraAcento("Sa�da"), "Saida");
	}

	@Test
	public void testPrimeiraLetra() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.primeiraLetra("Manuten��o"), "M");
		assertEquals(exercicios.primeiraLetra("Paran�"), "P");
		assertEquals(exercicios.primeiraLetra("Sa�da"), "S");
	}

	@Test
	public void testAcentuarAsLetrasADaPrimeiraPalavra() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.acentuarAsLetrasADaPrimeiraPalavra("Aula No S�bado"), "�ul� No S�bado");
		assertEquals(exercicios.acentuarAsLetrasADaPrimeiraPalavra("Marcela Alves"), "M�rcel� Alves");
	}
}
