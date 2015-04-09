package es.uniovi.asw.game.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import es.uniovi.asw.game.persistence.PersistenceService;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class PersistenceServiceImpl implements PersistenceService {

	private DBCollection collQuestions;
	private DBCollection collUser;

	public PersistenceServiceImpl() {

		collQuestions = MongoConnection.getInstance().getCollection();
		collUser = (MongoConnection.getInstance().getDB())
				.getCollection(MongoConnection.nameCollectionUser);
	}

	@Override
	public List<Question> getQuestionsCategory(String category) {
		List<Question> list = new ArrayList<Question>();
		Question q = new Question();
		Answer a = new Answer();
		DBObject cursor;
		Object obj;

		BasicDBObject filtro = new BasicDBObject();

		filtro.put("category", category);
		DBCursor cur = collQuestions.find(filtro);
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

		// HashSet<Question> hs = new HashSet<Question>();
		// hs.addAll(list);
		// list.clear();
		// list.addAll(hs);

		return list;
	}

	/**
	 * Datos que se meten en la BD del usuario : login, contraseña, si es
	 * privilegiado 0 para negar, 1 para acertar, nº preguntas acertadas, nº
	 * preguntas falladas, nº de partidas ganadas y nº de partidas perdidas
	 * 
	 * @param login
	 * @param passwd
	 * @param privilegiado
	 * @param questionSuccess
	 * @param questionsFailed
	 * @param matchSuccess
	 * @param matchFailed
	 */
	@Override
	public boolean saveUsuario(String login, String passwd, int privilegiado,
			int questionSuccess, int questionsFailed, int matchSuccess,
			int matchFailed) {

		BasicDBObject filtro = new BasicDBObject();

		filtro.put("login", login);
		DBCursor cur = collUser.find(filtro);

		if (cur.next().equals(null)) {
			return false;
		}

		DBObject doc = new BasicDBObject();

		doc.put("login", login);
		doc.put("passwd", passwd);
		doc.put("privilegio", privilegiado);
		doc.put("questionSuccess", questionSuccess);
		doc.put("questionsFailed", questionsFailed);
		doc.put("matchSuccess", matchSuccess);
		doc.put("matchFailed", matchFailed);

		collUser.insert(doc);

		cur = collUser.find(filtro);
		if (!cur.next().equals(null)) {
			return true;
		}
		return false;

	}

	@Override
	public boolean updateUsuarioQuestionsS(String login, int questionSuccess) {

		BasicDBObject filtro = new BasicDBObject();
		DBObject cursor;
		Integer obj;

		filtro.put("login", login);
		DBCursor cur = collUser.find(filtro);

		// cursor = cur.next();
		if (cur.next() == null) {
			return false;
		}
		// obj = (Integer) cursor.get("questionSuccess");

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set",
				new BasicDBObject().append("questionSuccess", questionSuccess));

		BasicDBObject searchQuery = new BasicDBObject().append("login", login);

		collUser.update(searchQuery, newDocument);

		cursor = findByLogin(login);
		obj = (Integer) cursor.get("questionSuccess");

		if (obj.equals(questionSuccess))
			return true;

		return false;
	}

	@Override
	public boolean updateUsuarioQuestionsF(String login, int questionsFailed) {
		DBObject cursor;
		Integer obj;

		cursor = findByLogin(login);
		if (cursor == null) {
			return false;
		}

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set",
				new BasicDBObject().append("questionsFailed", questionsFailed));

		BasicDBObject searchQuery = new BasicDBObject().append("login", login);

		collUser.update(searchQuery, newDocument);

		cursor = findByLogin(login);
		obj = (Integer) cursor.get("questionsFailed");

		if (obj.equals(questionsFailed))
			return true;

		return false;
	}

	@Override
	public boolean updateUsuarioPartidasGanadas(String login, int matchSuccess) {
		DBObject cursor;
		Integer obj;

		cursor = findByLogin(login);
		if (cursor == null) {
			return false;
		}

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set",
				new BasicDBObject().append("matchSuccess", matchSuccess));

		BasicDBObject searchQuery = new BasicDBObject().append("login", login);

		collUser.update(searchQuery, newDocument);

		cursor = findByLogin(login);
		obj = (Integer) cursor.get("matchSuccess");

		if (obj.equals(matchSuccess))
			return true;

		return false;
	}

	@Override
	public boolean updateUsuarioPartidasPerdidas(String login, int matchFailed) {
		DBObject cursor;
		Integer obj;

		cursor = findByLogin(login);
		if (cursor == null) {
			return false;
		}

		BasicDBObject newDocument = new BasicDBObject();
		newDocument.append("$set",
				new BasicDBObject().append("matchFailed", matchFailed));

		BasicDBObject searchQuery = new BasicDBObject().append("login", login);

		collUser.update(searchQuery, newDocument);

		cursor = findByLogin(login);
		obj = (Integer) cursor.get("matchFailed");

		if (obj.equals(matchFailed))
			return true;

		return false;
	}

	private DBObject findByLogin(String login) {
		BasicDBObject filtro = new BasicDBObject();
		DBObject cursor;

		filtro.put("login", login);
		DBCursor cur = collUser.find(filtro);

		cursor = cur.next();

		return cursor;
	}

	@Override
	public boolean deleteUsuario(String usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
