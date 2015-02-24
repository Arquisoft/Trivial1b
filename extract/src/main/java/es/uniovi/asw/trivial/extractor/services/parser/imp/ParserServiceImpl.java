package es.uniovi.asw.trivial.extractor.services.parser.imp;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.extractor.services.parser.ParserService;

public class ParserServiceImpl implements ParserService {
	public Parser getGiftParser(){
		return new GiftParser();
	}
}
