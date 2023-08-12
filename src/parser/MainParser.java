package parser;

import exc.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

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
		System.out.println("Digite a equacao booleana: ");
		entrada = scanner.nextLine();
		scanner.close();
		
		if (entrada.equals("") == true)
		{
			System.out.println("Arquivo  vazio, usanndo equacao padrao de testes....");
			entrada = equacaoPadrao.replaceAll(" ", "");
			System.out.println(entrada);
		}
		
		
		
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
