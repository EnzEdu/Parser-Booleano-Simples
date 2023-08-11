package parser;

import exc.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainParser {
	private static int numTestes = 5;
	
	public static void main(String[] args) {
	
		// Parser
		ArrayList<Character> tokensOperadores = new ArrayList<>(
				Arrays.asList('(', ')', '~', '&', '^', '|'));
		
		ArrayList<Character> tokensNumeros = new ArrayList<>(
				Arrays.asList('0', '1'));
		
		
		
		String entrada   = "~1 | (0^1 | 0&0)".replaceAll(" ", "");;
		String expressao = "";
		
		// Remocao de whitespaces
		expressao = entrada.replaceAll(" ", "");
		
		// Substituicao dos simbolos 0 e 1 por false e true
		expressao = expressao.replaceAll("0", "false");
		expressao = expressao.replaceAll("1", "true");

		
		
		System.out.println(entrada);
		//System.out.println(expressao);
		
		
		
		// Parser
		boolean nadaDeErrado = true;
		
		int testeAtual;
		for (testeAtual = 0; (testeAtual < numTestes && nadaDeErrado == true); testeAtual++)
		{
			switch (testeAtual)
			{
				case 0: nadaDeErrado = VerificaSimbolosGramatica.testar(entrada, tokensOperadores, tokensNumeros);
									   break;
				case 1: nadaDeErrado = VerificaNumeroParenteses.testar(entrada);
									   break;
				case 2: nadaDeErrado = VerificaOrdenacaoParenteses.testar(entrada);
									   break;
				case 3: nadaDeErrado = VerificaArgumentosOperacoes.testar(entrada, tokensOperadores, tokensNumeros);
									   break;
				case 4: nadaDeErrado = VerificaPosicaoNumeros.testar(entrada, tokensOperadores, tokensNumeros);
									   break;
			}
		}
		testeAtual--;
		
		
		
		// Imprime o resultado da analise sintatica
		if (nadaDeErrado == true) {
			System.out.println("Sintaxe correta!");
		}
		else
		{
			ApresentaExcecao.imprimir(testeAtual);
		}

	}
}
