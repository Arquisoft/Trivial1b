package infraestructura.impl;

import infraestructura.LogService;
import infraestructura.impl.adapter.ConsoleLogger;


public class LogServiceImpl implements LogService {

	@Override
	public Logger getLog() {
		// TODO Auto-generated method stub
		return new ConsoleLogger();
	}

}
