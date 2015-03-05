package es.uniovi.asw.trivial.extractor.services.serializer;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.model.Question;

/**
 * 
 * @author Adrián
 *
 */
public interface Serializer {
	/**
	 * 
	 * @param questions
	 * @return
	 */
	public String serialize(List<Question> questions);
}
