package es.uniovi.asw.game.model;

import java.util.ArrayList;
import java.util.List;

public class Partida {

	private final static int MAX = 6;
	private int dado;
	private List<User> usuarios;
	
	public Partida() {
		usuarios = new ArrayList<User>();

	}
	
	
	public List<User> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<User> usuarios) {
		this.usuarios = usuarios;
	}
	


	public int lanzarDado() {
		dado = (int)(Math.random() * MAX) + 1;
		return dado;
	}

	
}
