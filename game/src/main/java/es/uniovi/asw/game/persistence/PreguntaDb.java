package es.uniovi.asw.game.persistence;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class PreguntaDb {

	private SortedMap<String, Question> table = new TreeMap<String, Question>();

	public void addQuestion(String title, String question, List<Answer> answers) {
		table.put(title, new Question(question, answers));
	}

	public Integer size() {
		return table.size();
	}

	public Question lookup(String title) {
		return table.get(title);
	}
 
}