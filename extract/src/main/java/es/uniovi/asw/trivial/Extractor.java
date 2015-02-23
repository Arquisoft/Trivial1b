package main.java.es.uniovi.asw.trivial;

import java.util.ArrayList;
import java.util.List;

import main.java.es.uniovi.asw.trivial.common.model.Answer;
import main.java.es.uniovi.asw.trivial.common.model.Question;
import main.java.es.uniovi.asw.trivial.serializer.impl.JSonSerializer;

public class Extractor {
	
	public void usage() {
		System.out.println("Wellcome to Trivial Extractor");
	}
	public int run(String[] args) {
		if (args.length == 0) {
			usage();
			return 0;
		}
		return -1 ;
	}
	
	public static void main(String[] args) {
        new Extractor().run(args);
        JSonSerializer js=new JSonSerializer();
        
       
    }	
	
	
}
