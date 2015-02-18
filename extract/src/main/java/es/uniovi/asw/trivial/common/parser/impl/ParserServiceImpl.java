package es.uniovi.asw.trivial.common.parser.impl;

import java.util.List;

import es.uniovi.asw.trivial.common.model.Question;
import es.uniovi.asw.trivial.common.parser.IParser;
import es.uniovi.asw.trivial.common.parser.ParserService;

public class ParserServiceImpl implements ParserService {
	
	private IParser parser;

	@Override
	public List<Question> parser(String data, String format) {
		
		
		return parser.parser(data);
	}
	


}
