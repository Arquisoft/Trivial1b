package es.uniovi.asw.infraestructura.util;

/**
 * Clase que proporciona operaciones sobre listas de 4 enteros.
 * 
 *Ana Isabel Blanco González
 */
public class Operation {

	/**
	 * Maximo de una lista de 4 enteros.
	 * @param list  la lista
	 * @return int el maximo
	 */
	public static int maxNumber(int[] list) {

		return Math.max(Math.max(list[0], list[1]), Math.max(list[2], list[3]));

	}
	/**
	 * Minimo de una lista de 4 enteros.
	 * @param list  la lista
	 * @return int el minimo
	 */
	public static int minNumber(int[] list) {

		return Math.min(Math.min(list[0], list[1]), Math.min(list[2], list[3]));

	}
}
