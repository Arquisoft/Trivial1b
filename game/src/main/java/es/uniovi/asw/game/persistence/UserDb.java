package es.uniovi.asw.game.persistence;

import java.util.SortedMap;
import java.util.TreeMap;

import es.uniovi.asw.game.model.User;

public class UserDb {

	private SortedMap<String, User> table = new TreeMap<String, User>();
	
	public UserDb() {
	}


	public void addUser(String name, String password) {
		 FactoryService.getPersistenceService().saveUsuario(name, password, 0, 0, 0, 0, 0);
	}

	public Integer size() {
		return table.size();
	}

	public User lookup(String name) {
		return FactoryService.getPersistenceService().findUserByLogin(name);
	}

	public Boolean login(String name, String password) {
		User usuario =  FactoryService.getPersistenceService().findUserByLogin(name);
		if (usuario!=null) {
			return usuario.getPassword().equals(password);
		} else
			return false;
	}
}
