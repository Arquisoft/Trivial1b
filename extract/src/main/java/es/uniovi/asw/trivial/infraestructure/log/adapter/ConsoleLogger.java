package es.uniovi.asw.trivial.infraestructure.log.adapter;

import es.uniovi.asw.trivial.infraestructure.log.Logger;

public class ConsoleLogger extends BaseLogger implements Logger {

	@Override
	protected void print(String line) {
		System.out.println( line );
	}


}
