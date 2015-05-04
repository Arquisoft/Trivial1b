package infraestructura.util;

import infraestructura.util.casillas.Figura;
import infraestructura.util.casillas.Hexagono;
import infraestructura.util.casillas.Rectangulo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que extrae las coordenadas de las casillas de un fichero con formato
 * numerocasilla:coordenada1/coordenada2/.../coordenadaN
 * 
 * @author Ana Isabel Blanco González
 *
 */
public class ExtractorCoordenadas {

	private Map<Integer, Figura> mapa;

	public ExtractorCoordenadas() {
		leerFichero();
	}

	private void leerFichero() {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			// Apertura del fichero y creacion de BufferedReader para poder
			// hacer una lectura comoda (disponer del metodo readLine()).
			archivo = new File("app/resources/celdas.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);

			// Lectura del fichero
			String linea;
			mapa = new HashMap<Integer, Figura>();
			while ((linea = br.readLine()) != null) {
				// Separamos el id de la casilla de las coordenadas.
				tratarLinea(linea);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos
			// que se cierra tanto si todo va bien como si salta
			// una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * Trocea la línea y carga los puntos.
	 * 
	 * @param linea
	 *            que contiene la casilla y las coordenadas
	 */
	private void tratarLinea(String linea) {
		String[] l = linea.split(":");
		// Separamos las coordenadas.
		String[] coord = l[1].split("/");
		if (coord.length == 4) { // Celda normal
			Rectangulo r = new Rectangulo(coord);
			mapa.put(Integer.valueOf(l[0]), r);
		} else if (coord.length == 6) { // Celda central
			Hexagono h = new Hexagono(coord);
			mapa.put(Integer.valueOf(l[0]), h);
		}

	}

	public Map<Integer, Figura> getMapa() {
		return mapa;
	}

	public void setMapa(Map<Integer, Figura> mapa) {
		this.mapa = mapa;
	}

}
