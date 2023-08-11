package parser;

public class ApresentaExcecao {

	public static void imprimir(int idTeste) {
		
		switch (idTeste)
		{
			case 0: System.out.println("Erro de sintaxe! A expressao possui um simbolo nao pertencente a gramatica.");
					break;
			case 1: System.out.println("Erro de sintaxe! A expressao possui um erro no numero de parenteses.");
					break;
			case 2: System.out.println("Erro de sintaxe! A expressao possui um par de parenteses na ordem errada.");
					break;
			case 3: System.out.println("Erro de sintaxe! A expressao possui uma operacao invalida.");
					break;
		}
		
	}
	
}
