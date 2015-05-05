package es.uniovi.asw.trivial.infraestructure.log.impl;

import es.uniovi.asw.trivial.infraestructure.log.LogService;
import es.uniovi.asw.trivial.infraestructure.log.impl.adapter.ConsoleLogger;

public class LogServiceImpl implements LogService {

	@Override
	public Logger getLog() {
		// TODO Auto-generated method stub
		return new ConsoleLogger();
	}

}
