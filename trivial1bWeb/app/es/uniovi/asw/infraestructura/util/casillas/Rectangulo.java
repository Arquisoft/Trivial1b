package es.uniovi.asw.infraestructura.util.casillas;

import java.awt.Point;

import es.uniovi.asw.infraestructura.util.Operation;

/**
 * Clase que representa una casilla cuadrada
 * 
 * @author Ana Isabel Blanco González
 * 
 */
public class Rectangulo extends Figura {

	public Rectangulo(String[] coord) {
		Point[] puntos = new Point[4];

		for (int i = 0; i < coord.length; i++) {
			int x = Integer.valueOf(coord[i].split(",")[0]);
			int y = Integer.valueOf(coord[i].split(",")[1]);
			Point p = new Point(x, y);
			puntos[i] = p;
		}

		super.setPointList(puntos);
	}

	public Rectangulo(Point p1, Point p2, Point p3, Point p4) {
		Point[] puntos = new Point[4];
		puntos[0] = p1;
		puntos[1] = p2;
		puntos[2] = p3;
		puntos[3] = p4;
		super.setPointList(puntos);
	}

	public boolean contains(Point p) {

		Point[] plist = super.getPointList();

		Point v1 = plist[0];
		Point v2 = plist[1];
		Point v3 = plist[2];
		Point v4 = plist[3];

		int[] x = new int[4];
		int[] y = new int[4];
		for (int i = 0; i < plist.length; i++) {
			x[i] = plist[i].x;
			y[i] = plist[i].y;
		}

		//Comprobamos si está fuera de las coordenadas.
		if (p.x > Operation.maxNumber(x) || p.y > Operation.maxNumber(y)
				|| p.x < Operation.minNumber(x) || p.y < Operation.minNumber(y))
			return false;

		// Dividimos el rectangulo en triangulos.
		Triangulo t1 = new Triangulo(v1, v2, v3);
		Triangulo t2 = new Triangulo(v2, v3, v4);

		// Comprobamos si el punto está dentro de alguno de ellos.
		return t1.contains(p) || t2.contains(p);
	}

}
