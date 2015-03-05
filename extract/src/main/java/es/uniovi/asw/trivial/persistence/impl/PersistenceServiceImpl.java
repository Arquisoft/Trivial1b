package es.uniovi.asw.trivial.persistence.impl;

import java.util.List;

import com.mongodb.DB;
import com.mongodb.DBCollection;

import es.uniovi.asw.trivial.infraestructure.model.Question;
import es.uniovi.asw.trivial.persistence.PersistenceService;
public class PersistenceServiceImpl implements PersistenceService {
	private MongoConnection mongo = new MongoConnection();
	private DB database;
	public PersistenceServiceImpl() {
		database = mongo.getConnection().getDB("");
	}
	public void save(List<Question> questions){
		DBCollection questionsTable= database.getCollection("questions");
		DBCollection answersTable = database.getCollection("answers");
		
		for(Question quest : questions){
			
		}
		
	}

}
