package es.uniovi.asw.trivial.common.parser.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.trivial.common.model.Answer;
import es.uniovi.asw.trivial.common.model.Question;
import es.uniovi.asw.trivial.common.parser.IParser;

public class GiftParser implements IParser {
	private List<Question> questions = new ArrayList<Question>();
	private int index = 0;
	@Override
	public List<Question> parser(String data) {
		List<Question> questions = new ArrayList<Question>();
		int index = 0;

		for(String line : data.split("\n")){
			line = line.trim();
			if(line.startsWith("//") || line.equals(""))
				continue;
			if(line.startsWith("::")){
				String[] str = line.split("::");
				questions.add(index, new Question());
				questions.get(index).setTitle(str[0]);
				line = str[1];
				if(line.endsWith("{")){
					questions.get(index).setQuestion(line.replaceAll("{", ""));
				}else if(line.endsWith("}")){
					String lineAnswers = ((line.split("{"))[1]).replaceAll("}", "");
					convertLineToAnswer(lineAnswers);
					index++;
				}else{
					questions.get(index).setQuestion(line);
				}
			}else if(line.startsWith("{") && line.endsWith("}")){
				line = line.substring(1, line.length()-1);
				convertLineToAnswer(line);
			}else if(line.startsWith("=") && line.endsWith("}")){
				line = line.substring(0, line.length()-1);
				convertLineToAnswer(line);
				index++;
			}
			
		}
		return questions;
	}
	
	private void convertLineToAnswer(String line){
		
		String[] answers = line.split("~");
		for(String thing : answers){
			Answer answer = new Answer();
			if(thing.startsWith("=")){
				thing = thing.replaceFirst("=", "");
				String[] things = thing.split("#");
				answer.setResponse(things[0]);
				answer.setText(things[1]);
				questions.get(index).addTrueAnswer(answer);
			}else{
				String[] things = thing.split("#");
				answer.setResponse(things[0]);
				answer.setText(things[1]);
				questions.get(index).addFalseAnswer(answer);
			}
		}
	}

}
