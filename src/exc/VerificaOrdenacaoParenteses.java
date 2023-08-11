package exc;

/*
 * Se houver, verifica a ordenacao de todos os pares de parenteses
 * da entrada fornecida ao programa.
 * (analisa se os abre parenteses vem primeiro que os fecha parenteses)
*/
public class VerificaOrdenacaoParenteses {

	public static boolean testar(String entrada) {
		
		int indexInicialProcura;
		
		indexInicialProcura = 0;
		while (entrada.indexOf('(', indexInicialProcura) != -1) {
			int indexAbreParenteses  = entrada.indexOf('(', indexInicialProcura);
			int indexFechaParenteses = entrada.indexOf(')', indexAbreParenteses);
			
			if (indexFechaParenteses == -1) {
				return false;
			}
			
			indexInicialProcura = indexAbreParenteses + 1;
		}
		
		return true;
	}
	
}
