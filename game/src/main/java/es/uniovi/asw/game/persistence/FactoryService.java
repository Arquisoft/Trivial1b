package es.uniovi.asw.game.persistence;

import es.uniovi.asw.game.persistence.impl.PersistenceServiceImpl;
import es.uniovi.asw.trivial.infraestructure.log.impl.LogServiceImpl;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;

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
