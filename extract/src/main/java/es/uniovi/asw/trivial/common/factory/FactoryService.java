package es.uniovi.asw.trivial.common.factory;

import es.uniovi.asw.trivial.common.io.FileService;
import es.uniovi.asw.trivial.common.io.impl.FileServiceImpl;
import es.uniovi.asw.trivial.common.parser.IParser;
import es.uniovi.asw.trivial.common.parser.impl.GiftParser;

public class FactoryService {
	private FactoryService(){}
	public static FileService getFileService(){
		return new FileServiceImpl();
	}
	public static IParser getGiftParser(){
		return new GiftParser();
	}

}
