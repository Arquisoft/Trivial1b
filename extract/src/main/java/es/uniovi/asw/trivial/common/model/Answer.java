package main.java.es.uniovi.asw.trivial.common.model;

public class Answer {
	private String response;
	private String text;
	private Integer ID;
	
	public Integer getID(){
		return ID;
	}
	public Answer(String correct) {
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
	
	

}
