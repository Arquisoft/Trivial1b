package es.uniovi.asw.trivial.extractor.services.serializer.impl;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

/**
 * 
 * @author Adrián
 *
 */
public class JSonSerializer implements Serializer{

	List<Question> questions;
	/*
	 * (non-Javadoc)
	 * @see es.uniovi.asw.trivial.extractor.services.serializer.Serializer#serialize(java.util.List)
	 */
	@Override
	public String serialize(List<Question> questions) {
		StringBuilder jsonStr = new StringBuilder();
		for(Question question : questions){
			jsonStr.append("{");
			jsonStr.append("\"title\":");
			if(question.getTitle() != null)
				jsonStr.append("\""+question.getTitle()+"\"");
			else
				jsonStr.append("\"\"");
			jsonStr.append(",");
			jsonStr.append("\"question\":");
			if(question.getQuestion() != null)
				jsonStr.append("\""+question.getQuestion()+"\"");
			else
				jsonStr.append("\"\"");
			jsonStr.append(",");
			jsonStr.append("\"answersFalse\": [");
			Answer answerTrue = null;
			for(Answer answer : question.getAnswers()){
				if(answer.isCorrect())
					answerTrue = answer;
				else if(answer.getResponse() != null){
					jsonStr.append("\""+answer.getResponse()+"\"");
					jsonStr.append(",");
				}
					
			}
			jsonStr.deleteCharAt(jsonStr.length()-1);
			jsonStr.append("],");
			jsonStr.append("\"answersTrue\": [ \""+answerTrue.getResponse()+"\"]}");
			jsonStr.append("\n");
		}
		return jsonStr.toString();
	}
	
	//{"title": "titulo","texto": "texto","answersFalse": ["respuesta1", "respuesta2", "respuesta3"],"answersTrue": ["respuesta4"]}


}
