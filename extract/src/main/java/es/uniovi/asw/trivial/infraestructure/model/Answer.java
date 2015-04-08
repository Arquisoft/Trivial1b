package es.uniovi.asw.trivial.infraestructure.model;
/**
 * 
 * @author Adrián
 *
 */
public class Answer {
	
	private String response;
	private String text;
	private boolean correct;
	

	public Answer(String response, boolean correct) {
		this.response = response;
		this.correct = correct;
	}
	public Answer() {
		// TODO Auto-generated constructor stub
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
	

}
