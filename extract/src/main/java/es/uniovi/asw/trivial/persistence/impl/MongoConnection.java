package es.uniovi.asw.trivial.persistence.impl;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;

public class MongoConnection {
	private static MongoClient mongoClient;
	private static Logger log = FactoryService.getLogService();
	
	public static  MongoClient getConnection(){
		try {
			mongoClient = new MongoClient("localhost",8080);
		} catch (UnknownHostException e) {
			log.error("Erro al obtener una conexión");
		}
		return mongoClient;
	}
}
