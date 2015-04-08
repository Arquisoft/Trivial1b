package es.uniovi.asw.trivial;

import es.uniovi.asw.trivial.extractor.parsersystem.ParserSystemManager;

public class Extractor {
	
	public void usage() {
		
	}
	public int run(String[] args) {
		new ParserSystemManager(args);;
		return 0;
	}
	
	public static void main(String[] args) {
        new Extractor().run(args);
    }	
}
