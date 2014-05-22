import org.junit.Assert;
import org.junit.Test;

import Exception.InvalidExpressionException;

public class OperacoesTest {

	@Test
	public void testSomaTresMaisDois() throws InvalidExpressionException {
		String expressao = "3+2";
		double resultadoEsperado = 5;

		verificaExpressao(expressao, resultadoEsperado);
	}

	@Test
	public void testSomaDoisMaisUm() throws InvalidExpressionException {
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
	public void testExcecaoExpressaoInvalido()
			throws InvalidExpressionException {
		String expressao = "12+bc";
		Operacoes.calculaResultadoDeExpressaoPosFixada(expressao);
	}

	@Test(expected = InvalidExpressionException.class)
	public void testExcecaoExpressaoInvalidoComPonto()
			throws InvalidExpressionException {
		String expressao = "12.00+3";
		Operacoes.calculaResultadoDeExpressaoPosFixada(expressao);
	}

	@Test(expected = InvalidExpressionException.class)
	public void testExcecaoExpressaoInvalidoCaracterEspecial()
			throws InvalidExpressionException {
		String expressao = "12+@";
		Operacoes.calculaResultadoDeExpressaoPosFixada(expressao);
	}

	@Test
	public void testTresMultiplicandoDois() throws InvalidExpressionException {
		String expressao = "3*2";
		double resultadoEsperado = 6;

		verificaExpressao(expressao, resultadoEsperado);
	}

	@Test
	public void testOitoDividoDois() throws InvalidExpressionException {
		String expressao = "8/4";
		double resultadoEsperado = 2;

		verificaExpressao(expressao, resultadoEsperado);
	}

	@Test
	public void testConverteExpressao() throws InvalidExpressionException {
		String expressao = "(1+2)/(2-1)";
		String expressaoPosFixada = "12+21-/";

		String expressaoRetornada = Operacoes
				.converteExpressaoFixadaEmPosFixada(expressao);
		Assert.assertEquals(expressaoPosFixada, expressaoRetornada);
	}

	@Test
	public void testConverteExpressaoMultiplicacao()
			throws InvalidExpressionException {
		String expressao = "(4-2)*(2+1)";
		String expressaoPosFixada = "42-21+*";

		String expressaoRetornada = Operacoes
				.converteExpressaoFixadaEmPosFixada(expressao);
		Assert.assertEquals(expressaoPosFixada, expressaoRetornada);
	}

	@Test(expected = InvalidExpressionException.class)
	public void testConverteExpressaoInvalida()
			throws InvalidExpressionException {
		String expressao = "(4-2)*(2+a)";

		Operacoes.converteExpressaoFixadaEmPosFixada(expressao);
	}

	@Test(expected = InvalidExpressionException.class)
	public void testConverteExpressaoInvalidaComDolar()
			throws InvalidExpressionException {
		String expressao = "(4-2)*(2+$)";

		Operacoes.converteExpressaoFixadaEmPosFixada(expressao);
	}

	private void verificaExpressao(String expressao, double resultadoEsperado)
			throws InvalidExpressionException {
		Assert.assertEquals(resultadoEsperado,
				Operacoes.calculaResultadoDeExpressaoPosFixada(expressao), 0.05);
	}
}
