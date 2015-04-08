/**
 * Defines a game user
 */
package es.uniovi.asw.game.model;

/**
 * @author Labra
 *
 */
public class User {
  private final String name;
  private String password;
  
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
