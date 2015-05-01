package model.casillas;

import java.awt.Point;

/**
 * Clase que representa una casilla cuadrada
 * @author Ana Isabel Blanco González
 *
 */
public class Rectangulo extends Figura {

	public Rectangulo(String[] coord) {
		Point[] puntos = new Point[4];
	
		for (int i=0; i<coord.length; i++) {
			int x = Integer.valueOf(coord[i].split(",")[0]);
			int y = Integer.valueOf(coord[i].split(",")[1]);
			Point p = new Point(x, y);
			puntos[i] = p;
			}

		super.setPointList(puntos);
	}

}
