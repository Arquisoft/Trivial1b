package es.uniovi.asw.persistence;

import es.uniovi.asw.infraestructura.impl.LogServiceImpl;
import es.uniovi.asw.infraestructura.impl.Logger;
import es.uniovi.asw.persistence.impl.PersistenceServiceImpl;


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
