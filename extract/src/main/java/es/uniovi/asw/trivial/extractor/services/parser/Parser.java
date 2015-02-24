package es.uniovi.asw.trivial.extractor.services.parser;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.model.Question;

public interface Parser {
	public List<Question> parser(String data);
}
