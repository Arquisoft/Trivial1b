package es.uniovi.asw.trivial.common.parser;

import java.util.List;

import es.uniovi.asw.trivial.common.model.Question;

public interface ParserService {
	
	public List<Question> parser(String lines, String format);	

}
