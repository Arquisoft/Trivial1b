package es.uniovi.asw.game.persistence.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;
import es.uniovi.asw.trivial.persistence.PersistenceService;

public class PersistenceServiceImpl implements PersistenceService {

	private DBCollection coll;

	public PersistenceServiceImpl() {

		coll = MongoConnection.getInstance().getCollection();
	}

	public List<Question> getQuestionsCategory(String category) {
		List<Question> list = new ArrayList<Question>();
		Question q = new Question();
		Answer a = new Answer();
		DBObject cursor;
		Object obj;

		BasicDBObject filtro = new BasicDBObject();

		filtro.put("category", category);
		DBCursor cur = coll.find(filtro);
		while (cur.hasNext()) {

			cursor = cur.next();
			obj = cursor.get("title");
			q.setTitle(obj.toString());

			obj = cursor.get("text");

			q.setQuestion(obj.toString());

			obj = cursor.get("answersFalse");

			String diaArray[] = obj.toString().split(",");
			for (String s : diaArray) {
				a.setResponse(s);
				a.setCorrect(false);
				q.addAnswer(a);
			}

			obj = cursor.get("answersTrue");
			diaArray = obj.toString().split(",");
			for (String s : diaArray) {
				a.setResponse(s);
				a.setCorrect(true);
				q.addAnswer(a);
			}

			list.add(q);

		}

		HashSet<Question> hs = new HashSet<Question>();
		hs.addAll(list);
		list.clear();
		list.addAll(hs);

		return list;
	}

	/**
	 * Datos que se meten en la BD del usuario : login, contraseña, si es privilegiado 0 para negar, 1 para acertar,
	 * nº preguntas acertadas, nº preguntas falladas, nº de partidas ganadas y nº de partidas perdidas
	 * @param login
	 * @param passwd
	 * @param privilegiado
	 * @param questionSuccess
	 * @param questionsFailed
	 * @param matchSuccess
	 * @param matchFailed
	 */
	public void saveUsuario(String login, String passwd, int privilegiado,
			int questionSuccess, int questionsFailed, int matchSuccess, int matchFailed) {
		
		DBCollection coll;
		coll = (MongoConnection.getInstance().getDB()).getCollection(MongoConnection.nameCollectionUser);
		
		DBObject doc = new BasicDBObject();
		
		doc.put("login", login);
		doc.put("passwd", passwd);
		doc.put("privilegio", privilegiado);
		doc.put("questionSuccess", questionSuccess);
		doc.put("questionsFailed", questionsFailed);
		doc.put("matchSuccess", matchSuccess);
		doc.put("matchFailed", matchFailed);
		
		coll.insert(doc);
		

	}
}
