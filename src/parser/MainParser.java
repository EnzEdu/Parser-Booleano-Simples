package parser;

import exc.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

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
		
		
		
		try {
			
			// Cria o FileInputStream para ler o arquivo passado como parametro
			FileInputStream fis;
			if (args.length != 0)
			{
				fis = new FileInputStream(args[0]);
			}
			else	
			{
				fis = new FileInputStream("equacao.txt");
			}
				
			// Cria o BufferedReader
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
			// Faz a leitura linha por linha
			String linha;
			int numLinha = -1;
			while ((linha = br.readLine()) != null)
			{
				numLinha++;
					
				// Salva apenas a primeira linha do arquivo
				if (numLinha < 1)
				{
					entrada = linha.replaceAll(" ", "");
				}
			}
				
			// Fecha a stream de leitura
			fis.close();
			
		} catch (Exception e) {
			System.out.println("Erro na leitura do arquivo!!");
		}
		
		
		
		if (entrada.equals("") == true)
		{
			if (args.length != 0)
			{
				System.out.println("Arquivo  vazio, usanndo equacao padrao de testes....");
			}
			else
			{
				System.out.println("N rodou o jar nno  cmd passanno um arquivo txt ccom a equacao booleana como argumento, eu  vou usar  u,ma equacao  teste.............");
			}
			
			entrada = equacaoPadrao.replaceAll(" ", "");
		}
		
		System.out.println(entrada);

		

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
