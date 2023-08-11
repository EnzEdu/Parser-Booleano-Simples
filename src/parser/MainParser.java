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
	
		// Parser
		ArrayList<Character> tokensOperadores = new ArrayList<>(
				Arrays.asList('(', ')', '~', '&', '^', '|'));
		
		ArrayList<Character> tokensNumeros = new ArrayList<>(
				Arrays.asList('0', '1'));
		
		
		
		String entrada   = "~1 | (0^1 | 0&0)".replaceAll(" ", "");
		String expressao = "";
		
		if (args.length != 0)
		//if (args.length == 0)
		{
			
			try {
				// Cria o FileInputStream para ler o arquivo passado como parametro
				FileInputStream fis = new FileInputStream(args[0]);
				//FileInputStream fis = new FileInputStream("equacao.txt");
				
				// Cria o BufferedReader
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			
				// Faz a leitura linha por linha
				String linha;
				int numLinha = -1;
				while ((linha = br.readLine()) != null)
				{
					numLinha++;
					
					// Salva apenas as duas primeiras linhas do arquivo
					if (numLinha < 1)
					{
						entrada = linha;
					}
				}
				
				// Fecha a stream de leitura
				fis.close();
			} catch (Exception e) {
				System.out.println("mission  failed we get em  nex time");
			}
			
			entrada = entrada.replaceAll(" ", "");
			System.out.println(entrada);
		}
		else
		{
			System.out.println("N rodou o jar nno  cmd passanno um arquivo txt ccom a equacao booleana como argumento, eu  vou usar  u,ma equacao  teste.............");
			entrada   = "~1 | (0^1 | 0&0)".replaceAll(" ", "");
			System.out.println(entrada);
		}
		
		// Remocao de whitespaces
		expressao = entrada.replaceAll(" ", "");
		
		// Substituicao dos simbolos 0 e 1 por false e true
		expressao = expressao.replaceAll("0", "false");
		expressao = expressao.replaceAll("1", "true");

		
		
		//System.out.println(entrada);
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
