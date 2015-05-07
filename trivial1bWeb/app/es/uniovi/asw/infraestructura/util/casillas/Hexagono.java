package es.uniovi.asw.infraestructura.util.casillas;

import java.awt.Point;

/**
 * Clase que representa la casilla central del tablero redondo.
 * @author Ana Isabel Blanco González
 *
 */
public class Hexagono extends Figura {

	public Hexagono(String[] coord) {
		Point[] puntos = new Point[6];
		for (int i=0; i<coord.length; i++) {
			int x = Integer.valueOf(coord[i].split(",")[0]);
			int y = Integer.valueOf(coord[i].split(",")[1]);
			Point p = new Point(x, y);
			puntos[i] = p;
			}
		
		super.setPointList(puntos);
	}

	@Override
	public boolean contains(Point p) {
		Point[] puntos = super.getPointList();
		//Dividimos el hexagono en dos triángulos y un rectángulo.
		Triangulo tsuperior = new Triangulo(puntos[0], puntos[1], puntos[5]);
		Rectangulo rcentral = new Rectangulo(puntos[1], puntos[2], puntos[4], puntos[5]);
		Triangulo tinferior = new Triangulo(puntos[2], puntos[4], puntos[4]);
		return tsuperior.contains(p) || rcentral.contains(p) || tinferior.contains(p);
	}

}
