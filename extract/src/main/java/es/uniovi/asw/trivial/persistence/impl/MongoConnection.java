package es.uniovi.asw.trivial.persistence.impl;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;

import es.uniovi.asw.trivial.infraestructure.log.Log;

public class MongoConnection {
	private static MongoClient mongoClient;
	
	public static  MongoClient getConnection(){
		try {
			mongoClient = new MongoClient("localhost",8080);
		} catch (UnknownHostException e) {
			Log.error("Erro al obtener una conexión");
		}
		return mongoClient;
	}
}
