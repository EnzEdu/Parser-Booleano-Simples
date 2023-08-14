package testes;

import java.util.ArrayList;

/*
 * Verifica os simbolos adjacentes de cada operador booleano
 * da equacao fornecida ao programa.
*/
public class VerificaArgumentosOperacoes {

	public static String testar(String entrada, ArrayList<Character> tokensOperadores,  ArrayList<Character> tokensNumeros) {
		
		int indexInicialProcura;
		
		for (int i = 2; i < tokensOperadores.size(); i++) {
			
			char op = tokensOperadores.get(i);
			if (op == '~')
			{
				indexInicialProcura = 0;
				while (entrada.indexOf(op, indexInicialProcura) != -1) {
					boolean simboloValido2 = false;
					int indexOp = entrada.indexOf(op, indexInicialProcura);
					
					// Analisa o simbolo seguinte ao operador NOT
					if (indexOp+1 > -1 && indexOp+1 < entrada.length())
					{
						char simboloSeguinte = entrada.charAt(indexOp + 1);
					
						// Verifica se eh uma variavel
						for (char variavel : tokensNumeros)
						{
							if (simboloSeguinte == variavel)
							{
								simboloValido2 = true;
								break;
							}
						}
					
						// Verifica se eh um operador de precedencia
						// (abre parenteses)
						if (simboloSeguinte == tokensOperadores.get(0))
						{
							simboloValido2 = true;
						}
					}
					
					
					if (simboloValido2 == false)
					{
						return entrada.substring(indexOp, indexOp + 2);
					}
				
					indexInicialProcura = indexOp + 1;
				}
			}
			
			else
			{
				indexInicialProcura = 0;
				while (entrada.indexOf(op, indexInicialProcura) != -1) {
					boolean simboloValido1 = false, simboloValido2 = false;
					
					int indexOp = entrada.indexOf(op, indexInicialProcura);
					
					// Analisa o simbolo anterior ao operador
					if (indexOp-1 > -1 && indexOp-1 < entrada.length())
					{
						char simboloAnterior = entrada.charAt(indexOp - 1);
						
						// Verifica se eh uma variavel
						for (char variavel : tokensNumeros)
						{
							if (simboloAnterior == variavel)
							{
								simboloValido1 = true;
							}
						}
						
						// Verifica se eh um operador de precedencia
						// (fecha parenteses)
						if (simboloAnterior == tokensOperadores.get(1))
						{
							simboloValido1 = true;
						}
					}
					
					// Analisa o simbolo seguinte ao operador
					if (indexOp+1 > -1 && indexOp+1 < entrada.length())
					{
						char simboloSeguinte = entrada.charAt(indexOp + 1);
						
						// Verifica se eh uma variavel
						for (char variavel : tokensNumeros)
						{
							if (simboloSeguinte == variavel)
							{
								simboloValido2 = true;
							}
						}
						
						// Verifica se eh um operador de precedencia
						// (abre parenteses)
						if (simboloSeguinte == tokensOperadores.get(0))
						{
							simboloValido2 = true;
						}
						
						
						// Verifica se eh o argumento a direita eh um numero negativo
						// (til)
						if (simboloSeguinte == tokensOperadores.get(2))
						{
							simboloValido2 = true;
						}
					}
					
					
					if (simboloValido1 == false || simboloValido2 == false)
					{
						if (indexOp-1 > -1 && indexOp-1 < entrada.length())
						{
							if (indexOp+1 > -1 && indexOp+1 < entrada.length())
							{
								return entrada.substring(indexOp - 1, indexOp + 2);
							}
							else
							{
								return entrada.substring(indexOp - 1, indexOp + 1);
							}
						}
						else
						{
							if (indexOp+1 > -1 && indexOp+1 < entrada.length())
							{
								return entrada.substring(indexOp, indexOp + 2);
							}
							else
							{
								return entrada.substring(indexOp, indexOp + 1);
							}
						}
					}
					
					indexInicialProcura = indexOp + 1;
				}
			}
			
		}
		
		return "";
	}
	
}
