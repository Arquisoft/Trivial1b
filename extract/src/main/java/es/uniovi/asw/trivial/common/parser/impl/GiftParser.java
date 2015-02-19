/* Adrián García Bueno
 * 18/02/2015
 * 
 * Versión 3
 * Clase para el parseo de GIFT
 * 
 * Ejemplos de formatos soportados....
 * Texto de la cuestión? { answers }
 * Texto de la cuestión?
 * { answers }
 * ::Title:: texto de la cuestión 
 * { a
 *   n
 *   s
 *   w
 *   e
 *   r
 *   s
 * }
 */

package es.uniovi.asw.trivial.common.parser.impl;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.trivial.common.model.Answer;
import es.uniovi.asw.trivial.common.model.Question;
import es.uniovi.asw.trivial.common.parser.IParser;

public class GiftParser implements IParser {
	
	private List<Question> questions = new ArrayList<Question>();
	private int index = 0;
	private boolean answerState = false;
	private void recursiveParser(String line) {
		line = line.trim();
		if(line.isEmpty() || line.startsWith("//")) //Omitimos lineas vacias y comentarios
			return;
			
		if(line.startsWith("::")){ //Inicio de pregunta con título
			questions.add(index, new Question()); //Creamos la nueva pregunta!!
			String title = line.split("::")[0]; //Obtenemos el título
			questions.get(index).setTitle(title);
			recursiveParser(line.split("::")[1]); //dejamos la linea como si no tuviera título
		}else if(!answerState && !line.startsWith("{")){ //Texto!
			if(line.contains("{")){ //Si contiene un { es que hay parte de una respuesta en la linea
				recursiveParser(line.substring(0, line.indexOf("{")-1)); //Cogemos solo el texto de la pregunta y reparseamos
				answerState = true; //Ahora vamos a la respuesta  de la pregunta y activamos el modo respuesta
				recursiveParser(line.substring(line.indexOf("{"), line.length())); //parseamos el inicio de la respuesta.
			}
			questions.get(index).setQuestion(line);
		}else if(line.startsWith("{")){
			answerState = true; //Entramos en modo respuestas
			if(line.contains("}"))
				recursiveParser(line.substring(1, line.indexOf("}")-1));//Obtenemos las respuestas en una linea
			recursiveParser(line.substring(1, line.length())); //Si no hay caracter } o bien no hay nada despues de { o hay respuestas en todo caso reparseamos la linea
		}else if(answerState && !line.contains("{") && !line.contains("}")){
			if(line.startsWith("=")){
				if(line.contains("~")){
					String[] answers = line.split("~");
					for(String answer : answers)
						recursiveParser(answer);
				}else{
					String correct = line.substring(1, line.length());
					questions.get(index).addTrueAnswer(new Answer(correct));
				}
			}else{ //Entonces es una respuesta incorrecta.
				questions.get(index).addFalseAnswer(new Answer(line));
			}
		}else if(answerState && line.contains("}")){
			if(line.startsWith("}")){ //Final de la pregunta, cambia el question y será null, nueva pregunta
				answerState = false;
				index++;
				recursiveParser(line.substring(1, line.length()));
			}else{
				recursiveParser(line.substring(0, line.indexOf("}")-1));
				recursiveParser(line.substring(line.indexOf("}"),line.length()));//Debería entrar por el final.
			}
		}
	}
	@Override
	public List<Question> parser(String data) {
		for(String line : data.split("\n\r")){
			recursiveParser(line);
		}
		return questions;
		
	}
	
	

}
