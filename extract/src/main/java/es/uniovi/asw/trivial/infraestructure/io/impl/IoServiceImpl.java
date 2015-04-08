/*
 * 18/02/2015
 * Adrián García Bueno
 * Clase para proveer de una implementación de entrada y salida de lineas
 */
package es.uniovi.asw.trivial.infraestructure.io.impl;

import es.uniovi.asw.trivial.infraestructure.io.IoService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;

public class IoServiceImpl implements IoService {
	/*
	 * (non-Javadoc)
	 * @see es.uniovi.asw.trivial.infraestructure.io.IoService#getStreamFile()
	 */
	@Override
	public Stream getStreamFile() {
		// TODO Auto-generated method stub
		return new StreamFile();
	}

	

}
