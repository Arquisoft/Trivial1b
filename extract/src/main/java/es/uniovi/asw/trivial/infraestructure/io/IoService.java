package es.uniovi.asw.trivial.infraestructure.io;

/**
 * Esta clase se encarga de especificar una interfaz para 
 * tener un sistema de entrada salida,
 * que podría ser, de ficheros, de servicios en red.. etc
 * En este prototipo es solo ficheros locales..
 * @author Adrián
 *
 */
public interface IoService {
	/**
	 * Obtiene una interfaz Stream
	 * @return Stream objeto stream
	 */
	public Stream getStreamFile();

}
