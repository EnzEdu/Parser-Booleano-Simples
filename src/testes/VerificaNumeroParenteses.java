package testes;

/*
 * Se houver, verifica todos os pares de parenteses
 * da equacao fornecida ao programa.
 * (analisa se cada abre parenteses tem o seu fecha parenteses)
*/
public class VerificaNumeroParenteses {

	public static String testar(String entrada) {
		
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
		
		if (numeroParentesesAbertos < numeroParentesesFechados)
		{
			return "(";
		}
		
		if (numeroParentesesAbertos > numeroParentesesFechados)
		{
			return ")";
		}
		
		return "";
	}
	
}
