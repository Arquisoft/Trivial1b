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
	private String categoria;
	private List<Answer> answers = new LinkedList<Answer>();
	private boolean used;
	private int nAciertos;
	private int nFallos;

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public int getnAciertos() {
		return nAciertos;
	}

	public void setnAciertos(int nAciertos) {
		this.nAciertos = nAciertos;
	}

	public int getnFallos() {
		return nFallos;
	}

	public void setnFallos(int nFallos) {
		this.nFallos = nFallos;
	}

	public Question(String question, List<Answer> answers) {

		this.question = question;
		this.answers = answers;
	}

	public Question() {

	}

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

	public void addAnswer(Answer ans) {
		answers.add(ans);
	}

}
