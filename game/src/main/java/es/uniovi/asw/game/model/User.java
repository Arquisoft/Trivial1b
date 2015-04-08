/**
 * Defines a game user
 */
package es.uniovi.asw.game.model;


public class User {
	  public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}

	public int getnRightQuestions() {
		return nRightQuestions;
	}

	public void setnRightQuestions(int nRightQuestions) {
		this.nRightQuestions = nRightQuestions;
	}

	public int getnWrongQuestions() {
		return nWrongQuestions;
	}

	public void setnWrongQuestions(int nWrongQuestions) {
		this.nWrongQuestions = nWrongQuestions;
	}

	public int getnWonGames() {
		return nWonGames;
	}

	public void setnWonGames(int nWonGames) {
		this.nWonGames = nWonGames;
	}

	public int getnLostGames() {
		return nLostGames;
	}

	public void setnLostGames(int nLostGames) {
		this.nLostGames = nLostGames;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private final String name;
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

@Override
public String toString() {
	return "User [name=" + name + "]";
}
  
  


}
