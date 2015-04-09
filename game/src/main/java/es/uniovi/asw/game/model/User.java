/**
 * Defines a game user
 */
package es.uniovi.asw.game.model;

public class User {
	private String name;
	private String password;
	private boolean privileged;
	private int nRightQuestions;
	private int nWrongQuestions;
	private int nWonGames;
	private int nLostGames;

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
