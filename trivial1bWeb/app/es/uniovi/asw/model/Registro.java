package es.uniovi.asw.model;

import es.uniovi.asw.persistence.UserDb;

public class Registro {
	private String username;
	private String password;
	private String password2;

	public Registro() {
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword2() {
		return password2;
	}

	public String validate() {
		UserDb user = new UserDb();

		if (username.equals("") || password.equals("") || password2.equals(""))
			return "Falta algún dato por introducir";

		else if (user.lookup(username) != null)
			return "Ya existe un usuario con este identificicador";

		else if (!password.equals(password2))
			return "Las contraseñas no coinciden";

		return null;
	}
}