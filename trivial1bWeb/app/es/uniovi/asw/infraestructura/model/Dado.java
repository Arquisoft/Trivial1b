package es.uniovi.asw.infraestructura.model;

public class Dado {
	
	private static int maximo = 6;
	
	/**
	 * M�todo que genera numeros aleatorios entre 1 y 6
	 * @return resultado, n�mero generado
	 */
	public static int lanzar()
	{
		int resultado =  (int) ((Math.random() * maximo) + 1);
		return resultado;
	}
}