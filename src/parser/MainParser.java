package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import testes.*;

public class MainParser {
	private static int numTestes = 5;
	
	public static void main(String[] args) {
	
		// Estruturas padroes do parser
		ArrayList<Character> tokensOperadores = new ArrayList<>(
				Arrays.asList('(', ')', '~', '&', '^', '|'));
		
		ArrayList<Character> tokensNumeros = new ArrayList<>(
				Arrays.asList('0', '1'));
		
		String equacaoPadrao = "~1 | (0^1 | 0&0)";
		String entrada = "";
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Digite a equacao booleana: ");
		entrada = scanner.nextLine();
		scanner.close();
		
		if (entrada.equals("") == true)
		{
			System.out.println("Passou equacao vazia, usando equacao padrao de testes....");
			entrada = equacaoPadrao.replaceAll(" ", "");
			System.out.println(entrada);
		}
		
		
		
		// Parser
		String strErro = "";
		
		int testeAtual;
		for (testeAtual = 0; (testeAtual < numTestes && strErro.equals("")); testeAtual++)
		{
			switch (testeAtual)
			{
				case 0: strErro = VerificaSimbolosGramatica.testar(entrada, tokensOperadores, tokensNumeros);
								  break;
				case 1: strErro = VerificaNumeroParenteses.testar(entrada);
								  break;
				case 2: strErro = VerificaOrdenacaoParenteses.testar(entrada);
								  break;
				case 3: strErro = VerificaArgumentosOperacoes.testar(entrada, tokensOperadores, tokensNumeros);
								  break;
				case 4: strErro = VerificaPosicaoNumeros.testar(entrada, tokensOperadores, tokensNumeros);
								  break;
			}
		}
		testeAtual--;
		
		
		
		// Imprime o resultado da analise sintatica
		if (strErro.equals("")) {
			System.out.println("Sintaxe correta!");
		}
		else
		{
			ApresentaExcecao.imprimir(testeAtual, strErro);
		}

	}
}
