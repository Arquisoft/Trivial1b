package main.java.es.uniovi.asw.trivial.common.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String title;
	private String question;
	private List<Answer> falseAnswers= new ArrayList<Answer>();
	private List<Answer> trueAnswers= new ArrayList<Answer>();
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public void addTrueAnswer(Answer answer){
		trueAnswers.add(answer);
		
	}
	public void addFalseAnswer(Answer answer){
	
		falseAnswers.add(answer);
	}
	public List<Answer> getFalseAnswers() {
		return falseAnswers;
	}
	public List<Answer> getTrueAnswers() {
		return trueAnswers;
	}
	public void setFalseAnswers(List<Answer> falseAnswers) {
		this.falseAnswers = falseAnswers;
	}
	public void setTrueAnswers(List<Answer> trueAnswers) {
		this.trueAnswers = trueAnswers;
	}
	
	
	
	

}
