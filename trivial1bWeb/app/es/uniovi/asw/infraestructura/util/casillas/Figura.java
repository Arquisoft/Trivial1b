package es.uniovi.asw.infraestructura.util.casillas;

import java.awt.Point;

/**
 * Clase que representa las distintas casillas del tablero.
 * @author Ana Isabel Blanco González
 *
 */
public abstract class Figura {

	protected Point[] pointList;
	private String categoria;
	private boolean quesito=false;
	private boolean dado=false;
	private boolean central=false;
	
	public boolean isCentral() {
		return central;
	}

	public void setCentral(boolean central) {
		this.central = central;
	}

	public boolean isDado() {
		return dado;
	}

	public void setDado(boolean dado) {
		this.dado = dado;
	}


	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isQuesito() {
		return quesito;
	}

	public void setQuesito(boolean quesito) {
		this.quesito = quesito;
	}

	public Point[] getPointList() {
		return pointList;
	}

	public void setPointList(Point[] pointList) {
		this.pointList = pointList;
	}

	
	
	
	/**
	 * Comprueba que un punto está dentro de la casilla.
	 * @param p el punto a comprobar.
	 * @return true si está dentro, false si no lo está.
	 */
	public abstract boolean contains(Point p);
	
}

