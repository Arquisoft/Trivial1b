package main.java.es.uniovi.asw.trivial.common.parser.impl;

import java.util.List;

import main.java.es.uniovi.asw.trivial.common.model.Question;
import main.java.es.uniovi.asw.trivial.common.parser.IParser;
import main.java.es.uniovi.asw.trivial.common.parser.ParserService;

public class ParserServiceImpl implements ParserService {
	
	private IParser parser;

	@Override
	public List<Question> parser(String data, String format) {
		
		
		return parser.parser(data);
	}
	


}
