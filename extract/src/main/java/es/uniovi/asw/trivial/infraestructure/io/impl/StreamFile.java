package es.uniovi.asw.trivial.infraestructure.io.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.log.Log;
/**
 * Esta clase se encarga de implementar la especificación que proporciona el servicio de entrada salida.
 * @author Adrián
 *
 */
public class StreamFile implements Stream {
	
	@Override
	public String read(String path) {
		StringBuffer data = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			while(reader.ready()){
				String line = reader.readLine();
				data.append(line);
				data.append("\n");
			}
		}catch (IOException e) {
			e.printStackTrace();
			Log.error("Se ha producido un error de entrada/salida");
		} finally{
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
					Log.error("Se ha producido un error de entrada/salida");
				}
		}
		return data.toString();
	}

	@Override
	public void write(String path, String data) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			writer.write(data);
		} catch (IOException e) {
			e.printStackTrace();
			Log.error("Se ha producido un error de entrada/salida");
		} finally {
			if(writer != null)
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
				Log.error("Se ha producido un error de entrada/salida");
			}
		}
		
	}

}
