package main.java.es.uniovi.asw.trivial.serializer.impl;

import java.util.List;

import main.java.es.uniovi.asw.trivial.common.model.Question;
import main.java.es.uniovi.asw.trivial.serializer.ISerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSonSerializer implements ISerializer{

	List<Question> questions;
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	@Override
	public String serializer(List<Question> questions) {
		
		this.questions=questions;
		StringBuilder sb= new StringBuilder("{\"questions\":[");
		for(Question q: questions){
			sb.append(questionSerializer(q));
		}
		sb.append("]}");		
		return sb.toString();
	}
	
	public List<Question> getQuestions(){
		return questions;
	}
		
	private String questionSerializer(Question question) {
		String JSONrepresentation = gson.toJson(question);
		return JSONrepresentation;
	}
	
	/*
	 * {"questions":[{
  "title": "...",
  "question": "....",
  "falseAnswers": [
    {
      "response": ".....",
      "text": "....."
    },
    {
      "response": ".......",
      "text": "......."
    },
    ....... resto de respuestas en la lista de falsas
  ],
  "trueAnswers": [
    {
      "response": ".......",
      "text": "......"
    },
    {
      "response": ".....",
      "text": "....."
    },
    ...... resto de respuestas en la lista de verdaderas
  ]
	}{
  "title": "Titulo pregunta 11",
  "question": "Pregunta 11",
  "falseAnswers": [
  
  ..... resto de formato de las preguntas, 
	  
	 */
	

}
