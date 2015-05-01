package infraestructura.impl.adapter;

import infraestructura.impl.Logger;



public class ConsoleLogger extends BaseLogger implements Logger {

	@Override
	protected void print(String line) {
		System.out.println( line );
	}


}
