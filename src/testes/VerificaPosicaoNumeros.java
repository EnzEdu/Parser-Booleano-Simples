package testes;

import java.util.ArrayList;

/*
 * Verifica se todos os numeros da equacao estao
 * cercados por operadores.
*/
public class VerificaPosicaoNumeros {

	public static String testar(String entrada, ArrayList<Character> tokensOperadores,  ArrayList<Character> tokensNumeros) {
		
		int indexInicialProcura;
		
		for (char variavel : tokensNumeros) {
			indexInicialProcura = 0;
			
			while (entrada.indexOf(variavel, indexInicialProcura) != -1) {
				int indexVariavel = entrada.indexOf(variavel, indexInicialProcura);
			
			
				// Verifica se o simbolo anterior a variavel eh
				// uma outra variavel ou um fecha parenteses
				if (indexVariavel-1 > -1 && indexVariavel-1 < entrada.length())
				{
					char simboloAnterior = entrada.charAt(indexVariavel - 1);
					if (tokensNumeros.contains(simboloAnterior) == true ||
						simboloAnterior == tokensOperadores.get(1))
					{
						return entrada.substring(indexVariavel - 1, indexVariavel + 1);
					}
				}
			
			
				// Verifica se o simbolo seguinte a variavel eh
				// uma outra variavel ou um abre parenteses ou um operador NOT
				if (indexVariavel+1 > -1 && indexVariavel+1 < entrada.length())
				{
					char simboloSeguinte = entrada.charAt(indexVariavel + 1);
					if (tokensNumeros.contains(simboloSeguinte) == true ||
						simboloSeguinte == tokensOperadores.get(0) ||
						simboloSeguinte == tokensOperadores.get(2))
					{
						return entrada.substring(indexVariavel, indexVariavel + 2);
					}
				}
			
			
				indexInicialProcura = indexVariavel + 1;
			}
		}
		
		return "";
	}
	
}
