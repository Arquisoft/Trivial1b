package es.uniovi.asw.infraestructura.impl;

import es.uniovi.asw.infraestructura.LogService;
import es.uniovi.asw.infraestructura.impl.adapter.ConsoleLogger;


public class LogServiceImpl implements LogService {

	@Override
	public Logger getLog() {
		// TODO Auto-generated method stub
		return new ConsoleLogger();
	}

}
