/**
 * Defines a game user
 */
package es.uniovi.asw.infraestructura.model;

import java.util.HashMap;
import java.util.Map;

import es.uniovi.asw.infraestructura.util.casillas.Figura;

public class User {
	private String name;
	private String password;
	private boolean privileged;
	private int nRightQuestions;
	private int nWrongQuestions;
	private int nWonGames;
	private int nLostGames;
	private Figura figura;
	private Map<String,Boolean> quesitos = new HashMap<String,Boolean>();


	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;

	}
		
	
	public User() {}
	
	public void incrementarQuesitos(String categoria) {
		quesitos.put(categoria, true);
		
	}
	
	
	public Figura getFigura() {
		return figura;
	}

	public void setFigura(Figura figura) {
		this.figura = figura;
	}
	
	public Map<String, Boolean> getQuesitos() {
		return quesitos;
	}



	public void setQuesitos(Map<String, Boolean> quesitos) {
		this.quesitos = quesitos;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public int getnLostGames() {
		return nLostGames;
	}

	public int getnRightQuestions() {
		return nRightQuestions;
	}

	public int getnWonGames() {
		return nWonGames;
	}
	public int getnWrongQuestions() {
		return nWrongQuestions;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	public boolean isPrivileged() {
		return privileged;
	}
	public void setnLostGames(int nLostGames) {
		this.nLostGames = nLostGames;
	}
	public void setnRightQuestions(int nRightQuestions) {
		this.nRightQuestions = nRightQuestions;
	}

	public void setnWonGames(int nWonGames) {
		this.nWonGames = nWonGames;
	}

	public void setnWrongQuestions(int nWrongQuestions) {
		this.nWrongQuestions = nWrongQuestions;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

}
