package es.uniovi.asw.trivial.infraestructure.log.impl.adapter;

import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;

public class ConsoleLogger extends BaseLogger implements Logger {

	@Override
	protected void print(String line) {
		System.out.println( line );
	}


}
