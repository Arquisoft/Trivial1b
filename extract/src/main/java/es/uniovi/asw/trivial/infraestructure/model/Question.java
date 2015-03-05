package es.uniovi.asw.trivial.infraestructure.model;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Adrián
 *
 */
public class Question {
	private String title;
	private String question;
	private List<Answer> answers = new LinkedList<Answer>();

	
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
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	public void addAnswer(Answer ans){
		answers.add(ans);
	}

}
