package exc;

import java.util.ArrayList;

/*
 * Se houver, verifica a ordenacao de todos os pares de parenteses
 * da entrada fornecida ao programa.
*/
public class VerificaArgumentosOperacoes {

	public static boolean testar(String entrada, ArrayList<Character> tokensOperadores,  ArrayList<Character> tokensNumeros) {
		
		int indexInicialProcura;
		
		for (int i = 2; i < tokensOperadores.size(); i++) {
			boolean simboloValido1 = false, simboloValido2 = false;
			
			char op = tokensOperadores.get(i);
			if (op == '~')
			{
				indexInicialProcura = 0;
				while (entrada.indexOf(op, indexInicialProcura) != -1) {
					int indexOp = entrada.indexOf(op, indexInicialProcura);
					char simboloPosterior = entrada.charAt(indexOp + 1);
					
					// Verifica se o simbolo seguinte ao operador
					// eh uma variavel
					for (char variavel : tokensNumeros)
					{
						if (simboloPosterior == variavel)
						{
							simboloValido2 = true;
							break;
						}
					}
					
					// Verifica se o simbolo seguinte ao operador
					// eh um operador de precedencia (abre parenteses)
					if (simboloPosterior == tokensOperadores.get(0))
					{
						simboloValido2 = true;
					}
					
					
					if (simboloValido2 == false)
					{
						return false;
					}
					
					
					indexInicialProcura = entrada.indexOf(op, indexInicialProcura) + 1;
				}
			}
			
			else
			{
				indexInicialProcura = 0;
				while (entrada.indexOf(op, indexInicialProcura) != -1) {
					int indexOp = entrada.indexOf(op, indexInicialProcura);
					char simboloAnterior  = entrada.charAt(indexOp - 1);
					char simboloPosterior = entrada.charAt(indexOp + 1);
					
					// Verifica se os simbolos em volta do operador
					// sao variaveis
					for (char variavel : tokensNumeros)
					{
						if (simboloAnterior == variavel)
						{
							simboloValido1 = true;
						}
						
						if (simboloPosterior == variavel)
						{
							simboloValido2 = true;
						}
					}
					
					// Verifica se os simbolos em volta do operador
					// sao operadores de precedencia
					// (fecha parenteses - operador - abre parenteses)
					if (simboloAnterior == tokensOperadores.get(1))
					{
						simboloValido1 = true;
					}
					if (simboloPosterior == tokensOperadores.get(0))
					{
						simboloValido2 = true;
					}
					
					
					if (simboloValido1 == false || simboloValido2 == false)
					{
						return false;
					}
					
					
					indexInicialProcura = entrada.indexOf(op, indexInicialProcura) + 1;
				}
			}
			
		}
		
		return true;
	}
	
}
