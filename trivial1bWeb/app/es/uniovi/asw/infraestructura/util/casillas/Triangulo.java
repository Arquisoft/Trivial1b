package es.uniovi.asw.infraestructura.util.casillas;

import java.awt.Point;

public class Triangulo extends Figura {

	public Triangulo(Point p1, Point p2, Point p3) {
		Point[] puntos = new Point[3];
		puntos[0] = p1;
		puntos[1] = p2;
		puntos[2] = p3;

		super.setPointList(puntos);

	}

	/*
	 * En este caso se puede calcular si el punto está dentro por el área puesto
	 * que al realizar las medidas de los puntos a mano, es muy dificil que dos
	 * triángulos tengan el mismo área.
	 */
	@Override
	public boolean contains(Point p) {
		int x = p.x;
		int y = p.y;
		int x1 = pointList[0].x;
		int x2 = pointList[1].x;
		int x3 = pointList[2].x;
		int y1 = pointList[0].y;
		int y2 = pointList[1].y;
		int y3 = pointList[2].y;

		float at = area(x1, y1, x2, y2, x3, y3); // Calculamos el area del
													// triangulo completo
		/*
		 * Calculamos el area de cada uno de los triangulos que se forman al
		 * unir los vertices con el punto
		 */
		float a1 = area(x, y, x2, y2, x3, y3);
		float a2 = area(x1, y1, x, y, x3, y3);
		float a3 = area(x1, y1, x2, y2, x, y);

		return (at == a1 + a2 + a3);

	}

	float area(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (float) Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3
				* (y1 - y2)) / 2.0);
	}

}
