package es.uniovi.asw.trivial.extractor.services.parser;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.model.Question;
/**
 * 
 * @author Adrián
 *
 */
public interface Parser {
	/**
	 * Parsea una String y devuelve una lista de preguntas.
	 * @param data String en el formato adecuado
	 * @return	List<Question> lista de preguntas.
	 */
	public List<Question> parser(String data);
}
