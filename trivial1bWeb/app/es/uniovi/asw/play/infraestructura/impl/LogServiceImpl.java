package es.uniovi.asw.play.infraestructura.impl;

import es.uniovi.asw.play.infraestructura.LogService;
import es.uniovi.asw.play.infraestructura.impl.adapter.ConsoleLogger;


public class LogServiceImpl implements LogService {

	@Override
	public Logger getLog() {
		// TODO Auto-generated method stub
		return new ConsoleLogger();
	}

}
