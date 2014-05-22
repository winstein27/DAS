
import org.junit.Assert;
import org.junit.Test;


public class OperacoesTest {

		@Test
		public void testSomaTresMaisDois(){
			
			double resultadoEsperado = 5;
		Assert.assertEquals(resultadoEsperado,
				Operacoes.calculaResultado("3+2"), 0.05);
			
		}
		
		@Test
		public void testSomaDoisMaisUm(){
			
			double resultadoEsperado = 3;
			Assert.assertEquals(resultadoEsperado, Operacoes.calculaResultado("2+1"), 0.05);
			
		}
		

}
