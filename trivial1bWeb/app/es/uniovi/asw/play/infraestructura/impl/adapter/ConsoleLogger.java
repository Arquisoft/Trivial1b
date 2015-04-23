package es.uniovi.asw.play.infraestructura.impl.adapter;

import es.uniovi.asw.play.infraestructura.impl.Logger;



public class ConsoleLogger extends BaseLogger implements Logger {

	@Override
	protected void print(String line) {
		System.out.println( line );
	}


}
