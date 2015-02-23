/*
 * 18/02/2015
 * Adrián García Bueno
 * Clase para proveer de una implementación de entrada y salida de lineas
 */
package main.java.es.uniovi.asw.trivial.common.io.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import main.java.es.uniovi.asw.trivial.common.io.FileService;

public class FileServiceImpl implements FileService {

	@Override
	public String readFile(String path) {
		StringBuffer data = new StringBuffer();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			while(reader.ready()){
				String line = reader.readLine();
				data.append(line);
			}
		}catch (IOException e) {
			//Logger
		} finally{
			if(reader != null)
				try {
					reader.close();
				} catch (IOException e) {
					//Logger
				}
		}
		return data.toString();
	}

	@Override
	public void writeFile(String path, List<String> list) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(path));
			for(String line : list){
				writer.newLine();
				writer.write(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(writer != null)
			try {
				writer.close();
			} catch (IOException e) {
				//Logger
			}
		}
		
	}

}
