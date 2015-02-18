package es.uniovi.asw.trivial.common.parser;

import java.util.List;

import es.uniovi.asw.trivial.common.model.Question;

public interface IParser {
	
	public List<Question> parser(String data);

}
