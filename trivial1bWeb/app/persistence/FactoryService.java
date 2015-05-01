package persistence;

import infraestructura.impl.LogServiceImpl;
import infraestructura.impl.Logger;
import persistence.impl.PersistenceServiceImpl;


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
