package es.uniovi.asw.persistence.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;
import com.mongodb.util.JSON;

import es.uniovi.asw.infraestructura.impl.Logger;
import es.uniovi.asw.persistence.FactoryService;


/**
 * Clase que establece la conexion con la base de datos y se encarga de
 * inicilizar la BD de preguntas, implementa patron singleton y para su uso
 * basta con instanciar la clase PersisteceServiceImpl
 * 
 * @author María José Sanchez Doria
 * 
 */
public class MongoConnection {
//	private static MongoClient conn;

	private static DB db;

	private static DBCollection coll;

//	private static final String nombreBD = "trivial1B";

	private static final String fichero = "./preguntasTrivial.txt";
	private static final String ficheroUsers = "./users.txt";

	public static final String nameCollectionQuestion = "QuestionsAnswers";
	public static final String nameCollectionUser = "Users";

	private static Logger log = FactoryService.getLogService();

	private static MongoConnection instance = null;

	private MongoConnection() {
		connection();
		conectar();
		loadBD();
	}

	public static MongoConnection getInstance() {
		if (instance == null) {
			instance = new MongoConnection();
		}
		return instance;
	}

	@SuppressWarnings("deprecation")
	private void connection() {

		// conn = new MongoClient("localhost");

		String uriString = "mongodb://adminTrivial1b:trivial1b@ds041177.mongolab.com:41177/trivial1b";
		
		MongoURI uri = new MongoURI(uriString);
		try {
			db = uri.connectDB();
			db.authenticate(uri.getUsername(), uri.getPassword());
			//Set<String> colls = db.getCollectionNames();
			
		} catch (UnknownHostException e) {
			log.error("Error al obtener una conexion");
		} catch (MongoException me) {
			log.error("Error al obtener una conexion");
			
		}

	}

	private static DB conectar() {
		
		return db;
	}

	public DB getDB() {
		return db;
	}

	private static void loadBD() {
		loadQuestions();
		loadUsers();

	}

	@SuppressWarnings("resource")
	private static void loadUsers() {
		String s;
		coll = db.getCollection(nameCollectionUser);
		DBObject doc;

		try {

			if (coll.count() == 0) {
				FileReader fr = new FileReader(ficheroUsers);
				BufferedReader br = new BufferedReader(fr);

				while ((s = br.readLine()) != null) {

					doc = (DBObject) JSON.parse(s);
					coll.insert(doc);
				}
			}

		} catch (FileNotFoundException e) {
			log.error("Ruta de fichero no encontrada");
		} catch (IOException e) {
			log.error("Error al leer el fichero, fichero vacio");
		}

	}

	@SuppressWarnings("resource")
	private static void loadQuestions() {
		String s;
		coll = db.getCollection(nameCollectionQuestion);
		DBObject doc;

		try {
			if (coll.count() == 0) {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);

				while ((s = br.readLine()) != null) {

					doc = (DBObject) JSON.parse(s);

					coll.insert(doc);
				}
			}

		} catch (FileNotFoundException e) {
			log.error("Ruta de fichero no encontrada");
		} catch (IOException e) {
			log.error("Error al leer el fichero, fichero vacio");
		}
	}

	public DBCollection getCollection() {
		return coll;
	}

}
