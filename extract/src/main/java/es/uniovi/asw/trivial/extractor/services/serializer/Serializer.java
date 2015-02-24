package es.uniovi.asw.trivial.extractor.services.serializer;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.model.Question;

public interface Serializer {

	public String serialize(List<Question> questions);
}
