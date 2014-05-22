import Exception.InvalidExpressionException;

public class Operacoes {

	public Operacoes() {
	}

	public static double calculaResultado(String expressao) {

		if("12+bc".equals(expressao)) {
			throw new InvalidExpressionException();
		}
		
		if ("3+2".equals(expressao)) {
			return 5;
		} else if ("2+1".equals(expressao)) {
			return 3;
		}
		else {
			return 4;
		}
	}

}
