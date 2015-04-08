package es.uniovi.asw.trivial.extractor.services.parser;

/**
 * Esta clase se encarga de especificar una interfaz para proveer una interfaz Parser
 * @author Adrián
 *
 */
public interface ParserService {
	/**
	 * Obtiene una interfaz Parser de tipo GIFT
	 * @return Parser devuelve una interfaz Parser.
	 */
	public Parser getGiftParser();
	/**
	 * Obtiene una interfaz parser de tipo Json
	 * @return
	 */
	public Parser getJsonParser();
}
