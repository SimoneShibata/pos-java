import static org.junit.Assert.*;

import org.junit.Test;


public class TestExercicios {

	@Test
	public void testTiraAcento() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.tiraAcento("Manutenção"), "Manutencao");
		assertEquals(exercicios.tiraAcento("Paraná"), "Parana");
		assertEquals(exercicios.tiraAcento("Saída"), "Saida");
	}

	@Test
	public void testPrimeiraLetra() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.primeiraLetra("Manutenção"), "M");
		assertEquals(exercicios.primeiraLetra("Paraná"), "P");
		assertEquals(exercicios.primeiraLetra("Saída"), "S");
	}

	@Test
	public void testAcentuarAsLetrasADaPrimeiraPalavra() {
		Exercicios exercicios = new Exercicios();
		
		assertEquals(exercicios.acentuarAsLetrasADaPrimeiraPalavra("Aula No Sábado"), "Áulá No Sábado");
		assertEquals(exercicios.acentuarAsLetrasADaPrimeiraPalavra("Marcela Alves"), "Márcelá Alves");
	}
}
