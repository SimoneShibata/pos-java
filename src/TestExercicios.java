import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
		assertEquals(exercicio.tiraAcento("Manutenção"), "Manutencao");
		assertEquals(exercicio.tiraAcento("Paraná"), "Parana");
		assertEquals(exercicio.tiraAcento("Saída"), "Saida");
	}

	@Test
	public void testPrimeiraLetra() {
		assertEquals(exercicio.primeiraLetra("Manutenção"), "M");
		assertEquals(exercicio.primeiraLetra("Paraná"), "P");
		assertEquals(exercicio.primeiraLetra("Saída"), "S");
	}

	@Test
	public void testAcentuarAsLetrasADaPrimeiraPalavra() {
		assertEquals(exercicio.acentuarAsLetrasADaPrimeiraPalavra("Aula No Sábado"), "Áulá No Sábado");
		assertEquals(exercicio.acentuarAsLetrasADaPrimeiraPalavra("Marcela Alves"), "Márcelá Alves");
	}

	@Test
	public void testSepararFrases() {
		String[] fraseSeparada = exercicio.separarFrases("Olá! Tudo Bom?", "!");

		assertEquals(fraseSeparada[0], "Olá");
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

	@Test
	public void testExemploColecoes() {
		assertTrue(exercicio.exemploColecoes().size() > 0);		
		assertEquals(exercicio.exemploColecoes().stream().findFirst().get().getNome(), "Belinha");		
	}

	@Test
	public void testOrdenarString() {
		assertEquals(exercicio.ordernarString().stream().findFirst().get(), "Armando");		
	}

	@Test
	public void testBuscarCidades() {
		assertEquals(exercicio.buscarCidade("Maringá"), "Maringá");		
		assertEquals(exercicio.buscarCidade("Cambará"), "Cambará");		
		assertEquals(exercicio.buscarCidade("Tubarão"), null);
	}
}
