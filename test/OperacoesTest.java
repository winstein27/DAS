
import org.junit.Assert;
import org.junit.Test;

import Exception.InvalidExpressionException;


public class OperacoesTest {

		@Test
		public void testSomaTresMaisDois(){
			String expressao = "3+2";
			double resultadoEsperado = 5;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		@Test
		public void testSomaDoisMaisUm(){
			String expressao = "2+1";
			double resultadoEsperado = 3;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		@Test
		public void testDezMenosSeis() {
			String expressao = "10-6";
			double resultadoEsperado = 4;
			
			verificaExpressao(expressao, resultadoEsperado);
		}

		@Test(expected = InvalidExpressionException.class)
		public void testExcecaoExpressaoInvalido() {
			String expressao = "12+bc";
			Operacoes.calculaResultado(expressao);
		}
		
		private void verificaExpressao(String expressao, double resultadoEsperado) {
			Assert.assertEquals(resultadoEsperado, Operacoes.calculaResultado(expressao), 0.05);
		}
}
