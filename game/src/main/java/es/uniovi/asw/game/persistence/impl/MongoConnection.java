package es.uniovi.asw.game.persistence.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;

/**
 * Clase que establece la conexion con la base de datos y se encarga de inicilizar
 * la BD de preguntas, implementa patron singleton y para su uso basta con instanciar
 * la clase PersisteceServiceImpl
 * @author María José Sanchez Doria
 *
 */
public class MongoConnection {
	private static MongoClient conn;

	private static DB db;

	private static DBCollection coll;

	private static final String nombreBD = "trivial1B";

	private static final String fichero = "./preguntasTrivial.txt";
	
	 

	public static final String nameCollectionQuestion = "QuestionsAnswers";
	public static final String nameCollectionUser = "Users";

	private static Logger log = FactoryService.getLogService();

	private static MongoConnection instance = null;

	private MongoConnection() {
		getConnection();
		conectar();
		loadBD();
	}

	public static MongoConnection getInstance() {
		if (instance == null) {
			instance = new MongoConnection();
		}
		return instance;
	}

	private MongoClient getConnection() {
		try {
			conn = new MongoClient("localhost");
		} catch (UnknownHostException e) {
			log.error("Erro al obtener una conexiÃ³n");
		}
		return conn;
	}

	private static DB conectar() {
		db = conn.getDB(nombreBD);
		return db;
	}
	
	public  DB getDB(){
		return db;
	}

	@SuppressWarnings("resource")
	private static void loadBD() {
		String s = new String();
		
		coll = db.getCollection(nameCollectionQuestion);
		DBObject doc;

		try {
			
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);

			while ((s = br.readLine()) != null) {
				
				doc = (DBObject) JSON.parse(s);
				
				coll.insert(doc);
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
