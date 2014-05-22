
import org.junit.Assert;
import org.junit.Test;

import Exception.InvalidExpressionException;


public class OperacoesTest {

		@Test
		public void testSomaTresMaisDois() throws InvalidExpressionException{
			String expressao = "3+2";
			double resultadoEsperado = 5;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		@Test
		public void testSomaDoisMaisUm() throws InvalidExpressionException{
			String expressao = "2+1";
			double resultadoEsperado = 3;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		@Test
		public void testDezMenosSeis() throws InvalidExpressionException {
			String expressao = "10-6";
			double resultadoEsperado = 4;
			
			verificaExpressao(expressao, resultadoEsperado);
		}

		@Test(expected = InvalidExpressionException.class)
		public void testExcecaoExpressaoInvalido() throws InvalidExpressionException {
			String expressao = "12+bc";
			Operacoes.calculaResultado(expressao);
		}
		
		@Test(expected = InvalidExpressionException.class)
		public void testExcecaoExpressaoInvalidoComPonto() throws InvalidExpressionException {
			String expressao = "12.00+3";
			Operacoes.calculaResultado(expressao);
		}
		
		@Test(expected = InvalidExpressionException.class)
		public void testExcecaoExpressaoInvalidoCaracterEspecial() throws InvalidExpressionException {
			String expressao = "12+@";
			Operacoes.calculaResultado(expressao);
		}
		
		@Test
		public void testTresMultiplicandoDois() throws InvalidExpressionException{
			String expressao = "3*2";
			double resultadoEsperado = 6;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		@Test
		public void OitoDividoDois() throws InvalidExpressionException{
			String expressao = "8/4";
			double resultadoEsperado = 2;
			
			verificaExpressao(expressao, resultadoEsperado);
		}
		
		private void verificaExpressao(String expressao, double resultadoEsperado) throws InvalidExpressionException {
			Assert.assertEquals(resultadoEsperado, Operacoes.calculaResultado(expressao), 0.05);
		}
}
