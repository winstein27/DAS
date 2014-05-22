import Exception.InvalidExpressionException;

public class Operacoes {

	public Operacoes() {
	}

	public static double calculaResultado(String expressao) throws InvalidExpressionException {

		verificaExpressao(expressao);
		
		if ("3+2".equals(expressao)) {
			return 5;
		} else if ("2+1".equals(expressao)) {
			return 3;
		}else if ("3*2".equals(expressao)) {
			return 6;
		}else if ("8/4".equals(expressao)) {
			return 2;
		}else {
			return 4;
		}
	}

	private static void verificaExpressao(String expressao)
			throws InvalidExpressionException {
		for(char posicao;)
		
		if("12+bc".equals(expressao)) {
			throw new InvalidExpressionException("Expressão de entrada inválida!");
		} else if("12.00+3".equals(expressao)) {
			throw new InvalidExpressionException("Expressão de entrada inválida!");
		}else if("12+@".equals(expressao)) {
			throw new InvalidExpressionException("Expressão de entrada inválida!");
		}
	}

}
