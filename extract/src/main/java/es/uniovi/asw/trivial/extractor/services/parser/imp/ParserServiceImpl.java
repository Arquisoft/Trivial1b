package es.uniovi.asw.trivial.extractor.services.parser.imp;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.extractor.services.parser.ParserService;
/**
 * 
 * @author Adrián
 *
 */
public class ParserServiceImpl implements ParserService {
	/*
	 * (non-Javadoc)
	 * @see es.uniovi.asw.trivial.extractor.services.parser.ParserService#getGiftParser()
	 */
	public Parser getGiftParser(){
		return new GiftParser();
	}
	/*
	 * (non-Javadoc)
	 * @see es.uniovi.asw.trivial.extractor.services.parser.ParserService#getJsonParser()
	 */
	@Override
	public Parser getJsonParser() {
		// TODO Auto-generated method stub
		return new JsonParser();
	}
}
