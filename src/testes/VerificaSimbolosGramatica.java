package testes;

import java.util.ArrayList;

/*
 * Testa se todos os simbolos da entrada
 * pertencem a gramatica do programa.
*/
public class VerificaSimbolosGramatica {

	public static String testar(String entrada, ArrayList<Character> tokensOperadores,  ArrayList<Character> tokensNumeros) {
		
		for (char simbolo : entrada.toCharArray()) {
			if (tokensNumeros.indexOf(simbolo) == -1) {
				if (tokensOperadores.indexOf(simbolo) == -1) {
					return Character.toString(simbolo);
				}
			}
		}
		
		return "";
	}
	
}