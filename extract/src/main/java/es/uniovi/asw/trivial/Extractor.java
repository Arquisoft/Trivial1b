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
        List<Question> questions=crearQuestionPrueba();
        JSonSerializer js=new JSonSerializer();
        String jsString=js.serializer(questions);
       System.out.println(jsString);
    }	
	
	public static List<Question> crearQuestionPrueba(){
		List<Question> questions=new ArrayList<Question>();
		List<Answer> answerT=new ArrayList<Answer>();
		Answer a= new Answer("");
		Question q= new Question();
		for(int i=0;i<5;i++){
			a.setText("Texto respuesta "+i+" true");
			a.setResponse("Respuesta "+i+" true");
			
			answerT.add(a);
		}
		List<Answer> answerF=new ArrayList<Answer>();
		for(int i=0;i<5;i++){
			a.setText("Texto respuesta "+i+" false");
			a.setResponse("Respuesta "+i+" false");
			answerF.add(a);
		}
		
		for(int i=0; i<12; i++){
			q.setQuestion("Pregunta "+i);
			q.setTitle("Titulo pregunta "+i);
			q.setFalseAnswers(answerF);
			q.setTrueAnswers(answerT);
			questions.add(q);
		}
		return questions;
	}
}
