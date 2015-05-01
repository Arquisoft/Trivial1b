package persistence;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import model.User;

import com.mongodb.MongoTimeoutException;

public class UserDb {

	private SortedMap<String, User> table = new TreeMap<String, User>();
	private String[] usuarios = {"UO232346","UO227799","UO227982",
								"UO227648","UO191154","UO229803",
								"UO232334","UO224927","UO212948"};
	PersistenceService service;
	
	public UserDb() {
		try {
			service = FactoryService.getPersistenceService();
			List<User> users = service.getUsuarios();
			for(User u:users) {
				table.put(u.getName(), u);
			}
		}
		catch(MongoTimeoutException e) {
			crearUsuariosNoBD();
		}
		
		
	}


	private void crearUsuariosNoBD() {
		User u = null;
		for(int i=0; i<9; i++) {
			u = new User(usuarios[i], usuarios[i]);
			table.put(usuarios[i], u);
		}
	}


	public void addUser(String name, String password) {
		 try {
			service.saveUsuario(name, password, 0, 0, 0, 0, 0);
		} catch (NullPointerException e) {
			table.put(name, new User(name, password));
		}
	}

	public Integer size() {
		return table.size();
	}

	public User lookup(String name) {
		try {
			return service.findUserByLogin(name);
		} catch (NullPointerException e) {
			return table.get(name);
		}
	}

	public Boolean login(String name, String password) {
		User usuario;
		try {
			usuario = service.findUserByLogin(name);
		} catch (NullPointerException e) {
			usuario = lookup(name);
		}
		
		
		if (usuario!=null) {
			return usuario.getPassword().equals(password);
		} else
			return false;
	}
}
