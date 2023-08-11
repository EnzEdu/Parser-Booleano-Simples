package exc;

/*
 * Se houver, contabiliza todos os pares de parenteses
 * da entrada fornecida ao programa.
 * 
*/
public class VerificaNumeroParenteses {

	public static boolean testar(String entrada) {
		
		int indexInicialProcura;
		
		indexInicialProcura = 0;
		int numeroParentesesAbertos = 0;
		while (entrada.indexOf('(', indexInicialProcura) != -1)
		{
			numeroParentesesAbertos += 1;
			indexInicialProcura = entrada.indexOf('(', indexInicialProcura) + 1;
		}
		
		indexInicialProcura = 0;
		int numeroParentesesFechados = 0;
		while (entrada.indexOf(')', indexInicialProcura) != -1)
		{
			numeroParentesesFechados += 1;
			indexInicialProcura = entrada.indexOf(')', indexInicialProcura) + 1;
		}
		
		if (numeroParentesesAbertos != numeroParentesesFechados)
		{
			return false;
		}
		
		return true;
	}
	
}
