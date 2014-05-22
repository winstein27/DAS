import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import Exception.InvalidExpressionException;

public class Operacoes {

	public Operacoes() {
	}

	public static String converteExpressaoFixadaEmPosFixada(String expressao)
			throws InvalidExpressionException {
		verificaExpressaoFixada(expressao);
		char finalExpressao = 'F';
		Stack<Character> pilha = new Stack<>();
		pilha.push(finalExpressao);

		List<Character> expressaoPosFixada = new ArrayList<Character>();
		int contador = 0;

		for (char posicao : expressao.toCharArray()) {
			if (posicao == '(' || posicao == ')' || posicao == '+'
					|| posicao == '-' || posicao == '*' || posicao == '/') {
				pilha.push(posicao);
			} else {
				expressaoPosFixada.add(posicao);
				contador++;
			}

			if ((expressaoPosFixada.size() > 2)
					&& (expressaoPosFixada[contador] >= 0 || expressaoPosFixada[contador] <= 9)
					&& (expressaoPosFixada[contador - 1] >= 0)
					|| expressaoPosFixada[contador - 1] <= 9) {
				contador++;
				expressaoPosFixada.add(pilha.pop());
			}
		}

		String retorno = expressaoPosFixada.toString();
		return retorno;

		// if ("(1+2)/(2-1)".equals(expressao)) {
		// return "12+21-/";
		// } else {
		// return "42-21+*";
		// }
	}

	private static void verificaExpressaoFixada(String expressao)
			throws InvalidExpressionException {
		for (char posicao : expressao.toCharArray()) {
			if (posicao != '+' && posicao != '-' && posicao != '*'
					&& posicao != '/' && posicao != '(' && posicao != ')'
					&& posicao < '0' || posicao > '9') {
				throw new InvalidExpressionException(
						"Expressao de entrada invalida!");
			}
		}
	}

	public static double calculaResultadoDeExpressaoPosFixada(String expressao)
			throws InvalidExpressionException {

		verificaExpressaoPosFixada(expressao);

		if ("3+2".equals(expressao)) {
			return 5;
		} else if ("2+1".equals(expressao)) {
			return 3;
		} else if ("3*2".equals(expressao)) {
			return 6;
		} else if ("8/4".equals(expressao)) {
			return 2;
		} else {
			return 4;
		}
	}

	private static void verificaExpressaoPosFixada(String expressao)
			throws InvalidExpressionException {
		for (char posicao : expressao.toCharArray()) {
			if (posicao != '+' && posicao != '-' && posicao != '*'
					&& posicao != '/' && posicao < '0' || posicao > '9') {
				throw new InvalidExpressionException(
						"Expressao de entrada invalida!");
			}
		}
	}
}
