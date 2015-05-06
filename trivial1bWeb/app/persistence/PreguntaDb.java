package persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import model.Answer;
import model.Question;

import com.mongodb.MongoTimeoutException;

public class PreguntaDb {

	private SortedMap<String, List<Question>> table = new TreeMap<String, List<Question>>();
	private PersistenceService service;
	public PreguntaDb() {

		try {
			service = FactoryService.getPersistenceService();
			crearPreguntasCiencia();
			crearPreguntasEntretenimiento();
			crearPreguntasDeportes();
			crearPreguntasGeografia();
			crearPreguntasHistoria();
			crearPreguntasLiteratura();
		} catch (MongoTimeoutException e) {
			crearPreguntasNoBD();
		}
	}

	private void crearPreguntasNoBD() {

		crearArteYLit();
		crearHistoria();
		crearGeografia();
		crearDeportes();
		crearEntretenimiento();
		crearCiencia();

	}

	private void crearCiencia() {
		// Ciencia
		ArrayList<Question> preguntas = new ArrayList<Question>();
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
		preguntas.add(q);

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

		preguntas.add(q);
		table.put("Ciencia", preguntas);
	}

	private void crearArteYLit() {
		// Literatura
		ArrayList<Question> preguntas = new ArrayList<Question>();
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Pregunta
		q = new Question();
		q.setCategoria("Literatura");
		q.setTitle("El Señor de los Anillos");
		q.setQuestion("¿Cuál fue el último cumpleaños que celebró Bilbo Bolsón en Bolsón Cerrado?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("centesimodecimoprimero");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("centesimodecimosegundo ");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("octagesimo");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("nonagesimo");
		respuestas.add(a);

		q.setAnswers(respuestas);

		preguntas.add(q);

		// Pregunta
		q = new Question();
		q.setCategoria("Literatura");
		q.setTitle("Siglo XIII");
		q.setQuestion("Autor: 'Crónica general' (Sobre el pasado del hombre)");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("alfonso x el sabio");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Anonimo");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Arturo Pérez-Reverte");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Machado");
		respuestas.add(a);

		q.setAnswers(respuestas);

		preguntas.add(q);

		table.put("Arte y Literatura", preguntas);
	}

	private void crearHistoria() {
		ArrayList<Question> preguntas;
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Historia
		preguntas = new ArrayList<Question>();
		respuestas = new ArrayList<Answer>();
		// Pregunta
		q = new Question();
		q.setCategoria("Historia");
		q.setTitle("II Guerra Mundial");
		q.setQuestion("Potencias del Eje: Alemania, Italia y...");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("Japón");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("China");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("España");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Portugal");
		respuestas.add(a);

		q.setAnswers(respuestas);

		preguntas.add(q);

		// Pregunta
		q = new Question();
		q.setCategoria("Historia");
		q.setTitle("Historia antigua");
		q.setQuestion("¿A dónde fueron deportados los judíos tras la conquista de Jerusalén por Nabucodonosor?");
		q.setUsed(false);
		respuestas = new ArrayList<Answer>();
		// Respuesta verdadera
		a = new Answer();
		a.setCorrect(true);
		a.setResponse("babilonia");
		respuestas.add(a);

		// Respuestas falsas
		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Israel");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Grecia");
		respuestas.add(a);

		a = new Answer();
		a.setCorrect(false);
		a.setResponse("Egipto");
		respuestas.add(a);
		q.setAnswers(respuestas);
		preguntas.add(q);

		table.put("Historia", preguntas);
	}

	private void crearGeografia() {
		ArrayList<Question> preguntas;
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Geografia
		preguntas = new ArrayList<Question>();
		respuestas = new ArrayList<Answer>();
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

		preguntas.add(q);

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

		preguntas.add(q);

		table.put("Geografia", preguntas);
	}

	private void crearDeportes() {
		ArrayList<Question> preguntas;
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Deportes
		preguntas = new ArrayList<Question>();
		respuestas = new ArrayList<Answer>();
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

		preguntas.add(q);

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

		preguntas.add(q);

		table.put("Deportes", preguntas);
	}

	private void crearEntretenimiento() {
		ArrayList<Question> preguntas;
		Question q;
		List<Answer> respuestas;
		Answer a;
		// Entretenimiento
		preguntas = new ArrayList<Question>();
		respuestas = new ArrayList<Answer>();
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

		preguntas.add(q);

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

		preguntas.add(q);

		table.put("Espectaculos", preguntas);
	}

	private void crearPreguntasLiteratura() {
		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Arte y Literatura");

		table.put("Arte y Literatura", preguntas);
	}

	private void crearPreguntasHistoria() {
		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Historia");
		table.put("Historia", preguntas);

	}

	private void crearPreguntasGeografia() {
		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Geografía");
		table.put("Geografía", preguntas);

	}

	private void crearPreguntasDeportes() {
		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Deportes");
		table.put("Deportes", preguntas);

	}

	private void crearPreguntasEntretenimiento() {

		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Espectaculos");
		table.put("Espectaculos", preguntas);

	}

	private void crearPreguntasCiencia() {
		ArrayList<Question> preguntas = service
				.getQuestionsCategory("Ciencia");
		table.put("Ciencia", preguntas);

	}

	// public void addQuestion(String title, String question, List<Answer>
	// answers) {
	// table.put(title, new Question(question, answers));
	// }

	/*
	 *  WARNING: no se usa
	 */
	@SuppressWarnings("unused")
	private void addQuestion(Question q, ArrayList<Question> lista) {
		table.put(q.getCategoria(), lista);
	}

	public Integer size() {
		return table.size();
	}

	public Question lookup(String category) {
		List<Question> preguntas = comprobarPreguntas(table.get(category));
		Question q = preguntas.get((int) (Math.random() * preguntas.size()));;

		while (q.isUsed()) {
			q = preguntas.get((int) (Math.random() * preguntas.size()));
		}

		return q;
	}

	private List<Question> comprobarPreguntas(List<Question> lista) {
		for (Question q : lista) {
			if (!q.isUsed()) {
				return lista;
			}
		}

		return resetearRespuestas(lista);
	}

	public List<Question> resetearRespuestas(List<Question> preguntas) {
		for (Question q : preguntas) {
			q.setUsed(false);
		}
		return preguntas;
	}

}