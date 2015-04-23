package es.uniovi.asw.play.persistence;

import es.uniovi.asw.play.infraestructura.impl.LogServiceImpl;
import es.uniovi.asw.play.infraestructura.impl.Logger;
import es.uniovi.asw.play.persistence.impl.PersistenceServiceImpl;


public class FactoryService {
	
	private static Logger log = new LogServiceImpl().getLog();
	
	private FactoryService(){}
	
	public static Logger getLogService(){
		return log;
	}
	
	public static PersistenceService getPersistenceService(){
		return new PersistenceServiceImpl();
	}

}
