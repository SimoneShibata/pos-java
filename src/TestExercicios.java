import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Before;
import org.junit.Test;


public class TestExercicios {
	
	private Exercicios exercicio;
	
	@Before
	public void before() {
		exercicio = new Exercicios();
	}
	
	@Test
	public void testTiraAcento() {
		assertEquals(exercicio.tiraAcento("Manuten��o"), "Manutencao");
		assertEquals(exercicio.tiraAcento("Paran�"), "Parana");
		assertEquals(exercicio.tiraAcento("Sa�da"), "Saida");
	}

	@Test
	public void testPrimeiraLetra() {
		assertEquals(exercicio.primeiraLetra("Manuten��o"), "M");
		assertEquals(exercicio.primeiraLetra("Paran�"), "P");
		assertEquals(exercicio.primeiraLetra("Sa�da"), "S");
	}

	@Test
	public void testAcentuarAsLetrasADaPrimeiraPalavra() {
		assertEquals(exercicio.acentuarAsLetrasADaPrimeiraPalavra("Aula No S�bado"), "�ul� No S�bado");
		assertEquals(exercicio.acentuarAsLetrasADaPrimeiraPalavra("Marcela Alves"), "M�rcel� Alves");
	}

	@Test
	public void testSepararFrases() {
		String[] fraseSeparada = exercicio.separarFrases("Ol�! Tudo Bom?", "!");

		assertEquals(fraseSeparada[0], "Ol�");
		assertEquals(fraseSeparada[1], " Tudo Bom?");
	}

	@Test
	public void testBuscarPalavraCimaDeArquivo() {
		assertTrue(exercicio.contemValorNoArquivo("cima"));
		assertFalse(exercicio.contemValorNoArquivo("jose"));
	}
	

	@Test
	public void testArquivoCidade() {
		exercicio.criaArquivoCidade();
		exercicio.lerArquivoCidades();
	}

}
