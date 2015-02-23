package main.java.es.uniovi.asw.trivial.common.factory;

import main.java.es.uniovi.asw.trivial.common.io.FileService;
import main.java.es.uniovi.asw.trivial.common.io.impl.FileServiceImpl;
import main.java.es.uniovi.asw.trivial.common.parser.IParser;
import main.java.es.uniovi.asw.trivial.common.parser.impl.GiftParser;
import main.java.es.uniovi.asw.trivial.serializer.ISerializer;
import main.java.es.uniovi.asw.trivial.serializer.impl.JSonSerializer;

public class FactoryService {
	
	private FactoryService(){}
	
	public static FileService getFileService(){
		return new FileServiceImpl();
	}
	
	public static IParser getGiftParser(){
		return new GiftParser();
	}
	
	public static ISerializer getJSonSerializer(){
		return new JSonSerializer();
	}
	
	

}
