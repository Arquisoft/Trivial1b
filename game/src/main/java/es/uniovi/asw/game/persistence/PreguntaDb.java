package es.uniovi.asw.game.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class PreguntaDb {

	private SortedMap<String, Question> table = new TreeMap<String, Question>();

	public PreguntaDb() {

		crearPreguntasCiencia();
		crearPreguntasEntretenimiento();
		crearPreguntasDeportes();
		crearPreguntasGeografia();
		crearPreguntasHistoria();
		crearPreguntasLiteratura();

	}

	private void crearPreguntasLiteratura() {
		// TODO generar preguntas literatura

	}

	private void crearPreguntasHistoria() {
		// TODO generar preguntas historia

	}

	private void crearPreguntasGeografia() {
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Pregunta
		q = new Question();
		q.setCategoria("Geografia");
		q.setTitle("Gentilicios");
		q.setQuestion("¿¿Cómo se llaman los nacidos en Córcega?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("corsos");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("chichilindris ");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("jienenses");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("accitanos");
		respuestas.add(a);

		q.setAnswers(respuestas);

		addQuestion(q);
		
		
		// Pregunta
		q = new Question();
		q.setCategoria("Geografia");
		q.setTitle("España");
		q.setQuestion("¿Con qué provincia limita al sur Valencia?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("Alicante");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Madrid ");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Murcia");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Barcelona");
		respuestas.add(a);

		q.setAnswers(respuestas);

		addQuestion(q);
	
	}

	private void crearPreguntasDeportes() {
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Pregunta
		q = new Question();
		q.setCategoria("Deportes");
		q.setTitle("Hípica");
		q.setQuestion("¿Cómo se llama el lugar destinado a las carreras de caballos?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("hipodromo");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("cuadrilatero");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("pista finlandesa");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("caballodromo");
		respuestas.add(a);

		q.setAnswers(respuestas);

		addQuestion(q);

		// Pregunta
		q = new Question();
		q.setCategoria("Deportes");
		q.setTitle("Futbol");
		q.setQuestion("¿Dónde nació el guardameta Cañizares?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("Puertollano");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Basauri");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Sabadell");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Monzon");
		respuestas.add(a);

		q.setAnswers(respuestas);

		addQuestion(q);
	}

	private void crearPreguntasEntretenimiento() {
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Pregunta
		q = new Question();
		q.setCategoria("Entretenimiento");
		q.setTitle("Anuncios");
		q.setQuestion("U-i-u-a-a, din, don, toma...");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("lacasitos");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("agua");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("sidra");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("cachopo");
		respuestas.add(a);

		q.setAnswers(respuestas);

		addQuestion(q);

		// Pregunta
		q = new Question();
		q.setCategoria("Entretenimiento");
		q.setTitle("TV-Series");
		q.setQuestion("¿Quién de estos personajes de Juego de Tronos no muere?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("Margaery Tyrell");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Ned Stark");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Ygritte");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Khal Drogo");
		respuestas.add(a);

		q.setAnswers(respuestas);
	}

	private void crearPreguntasCiencia() {
		// Pregunta 1
		Question q = new Question();
		q.setCategoria("Ciencia");
		q.setTitle("Aeronautica");
		q.setQuestion("Enero de 1923, Madrid, Cuatro Vientos: ¿Qué aparato efectúa su primer vuelo?");
		q.setUsed(false);
		List<Answer> respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		Answer a = new Answer();
		a.setCorrect(true);
		a.setResponse("autogiro de juan de la cierva");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("helicoptero");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("zepelin");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("avion");
		respuestas.add(a);

		q.setAnswers(respuestas);
		addQuestion(q);

		// Pregunta 2
		q = new Question();
		q.setCategoria("Ciencia");
		q.setTitle("Informatica");
		q.setQuestion("Sacar datos de la pila (stack): ¿instrucción?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("pop");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("push");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("call");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("ret");
		respuestas.add(a);

		q.setAnswers(respuestas);
		addQuestion(q);
	}

	public void addQuestion(String title, String question, List<Answer> answers) {
		table.put(title, new Question(question, answers));
	}

	private void addQuestion(Question q) {
		table.put(q.getTitle(), q);
	}

	public Integer size() {
		return table.size();
	}

	public Question lookup(String title) {
		return table.get(title);
	}

}