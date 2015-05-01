package model.casillas;

import java.awt.Point;

/**
 * Clase que representa las distintas casillas del tablero.
 * @author Ana Isabel Blanco González
 *
 */
public abstract class Figura {

	private Point[] pointList;
	
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
	public boolean contains(Point p) {

		int counter = 0;
		int i;
		int xinters;
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, 0);
		int n = pointList.length;

		p1 = pointList[0];
		for (i = 1; i <= n; i++) {
			p2 = pointList[i % n];
			if (p.y > Math.min(p1.y, p2.y)) {
				if (p.y <= Math.max(p1.y, p2.y)) {
					if (p.x <= Math.max(p1.x, p2.x)) {
						if (p1.y != p2.y) {
							xinters = (p.y - p1.y) * (p2.x - p1.x)
									/ (p2.y - p1.y) + p1.x;
							if (p1.x == p2.x || p.x <= xinters)
								counter++;
						}
					}
				}
			}
			p1 = p2;
		}
		if (counter % 2 == 0) {
			return false;
		} else {
			return true;
		}
	}
	
}

