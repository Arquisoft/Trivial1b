package es.uniovi.asw.game.model;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.game.persistence.PreguntaDb;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class Partida {

	private PreguntaDb preguntas = new PreguntaDb();
	private final static int MAX = 6;
	private int dado;
	private List<User> usuarios;

	public Partida() {
		usuarios = new ArrayList<User>();
		crearPreguntaPrueba();
	}

	private void crearPreguntaPrueba() {
		List<Answer> answers = new ArrayList<Answer>();
		Answer a1 = new Answer("Madrid", true);
		Answer a2 = new Answer("Barcelona", false);
		answers.add(a1);
		answers.add(a2);
		preguntas.addQuestion("GEOGRAFIA", "¿Capital de España?", answers);
	}

	public List<User> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}

	public int lanzarDado() {
		dado = (int) (Math.random() * MAX) + 1;
		return dado;
	}

	public Question sacarPregunta() {
		return preguntas.lookup("GEOGRAFIA");

	}
}