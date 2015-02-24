package es.uniovi.asw.trivial.infraestructure.factories;

import es.uniovi.asw.trivial.extractor.services.parser.ParserService;
import es.uniovi.asw.trivial.extractor.services.parser.imp.ParserServiceImpl;
import es.uniovi.asw.trivial.extractor.services.serializer.SerializerService;
import es.uniovi.asw.trivial.extractor.services.serializer.impl.SerializerServiceImpl;
import es.uniovi.asw.trivial.infraestructure.io.IoService;
import es.uniovi.asw.trivial.infraestructure.io.impl.IoServiceImpl;


public class FactoryService {
	private FactoryService(){}
	public static ParserService getParserService(){
		return new ParserServiceImpl();
	}
	public static SerializerService getSerializerService(){
		return new SerializerServiceImpl();
	}
	public static IoService getIoService(){
		return new IoServiceImpl();
	}

	
	

}
