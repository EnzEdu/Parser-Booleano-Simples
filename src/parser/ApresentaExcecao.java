package parser;

public class ApresentaExcecao {

	public static void imprimir(int idTeste, String strErro) {
		
		switch (idTeste)
		{
			case 0: System.out.println("Erro de sintaxe! Detectado simbolo invalido \"" + strErro + "\" dentro da sentenca!");
					break;
			case 1: System.out.println("Erro de sintaxe! Detectado erro no numero de parenteses, pois a sentenca carece de ao menos um \"" + strErro + "\"!");
					break;
			case 2: System.out.println("Erro de sintaxe! Detectado erro de ordenacao entre os pares de parenteses da sentenca!");
					break;
			case 3: System.out.println("Erro de sintaxe! Detectado erro na utilizacao de operador em \"" + strErro + "\"!");
					break;
			case 4: System.out.println("Erro de sintaxe! Detectada concatenacao invalida de variaveis em \"" + strErro + "\"!");
					break;
		}
		
	}
	
}
