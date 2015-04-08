package es.uniovi.asw.trivial.infraestructure.log.impl.adapter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;

public class FileLogger extends BaseLogger implements Logger {

	private PrintStream printer;
	public FileLogger(PrintStream stream) {
		setStream(stream);
	}
	public FileLogger(String string) {
		try {
			printer = new PrintStream(new File(string));
		} catch (FileNotFoundException e) {
			printer = System.out;
		}
	}
	@Override
	protected void print(String line) {
		printer.println(line);
	}
	
	public void setStream(PrintStream stream) {
		this.printer = stream;
	}

}
