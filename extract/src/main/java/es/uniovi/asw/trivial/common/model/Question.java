package es.uniovi.asw.trivial.common.model;

import java.util.List;

public class Question {
	private String title;
	private String question;
	private List<Answer> falseAnswers;
	private List<Answer> trueAnswers;
	
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
		
	}
public void addFalseAnswer(Answer answer){
		
	}
	

}
