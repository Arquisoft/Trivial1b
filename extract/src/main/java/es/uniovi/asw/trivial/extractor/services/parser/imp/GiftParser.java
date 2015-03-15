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

package es.uniovi.asw.trivial.extractor.services.parser.imp;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;


/**
 * Esta clase implementa un Parseador Gift
 * @author Adrián
 *
 */
public class GiftParser implements Parser {
	private Logger log = FactoryService.getLogService();
	private List<Question> questions = new ArrayList<Question>();
	private int index = 0;
	private boolean answerState = false;
	private boolean correctYet = false;
	/*
	 * Método de la muerte
	 */
	private void recursiveParser(String line) {
		
		line = line.trim();		//Quitamos los espacios sobrantes de la linea
		if(line.isEmpty() || line.startsWith("//") || line.startsWith("$")) //Omitimos lineas vacias y comentarios
			return;
		if(line.startsWith("::")){ //Inicio de pregunta con título
			questions.add(index, new Question()); //Creamos la nueva pregunta!!
			String title = line.split("::")[0]; //Obtenemos el título
			questions.get(index).setTitle(title);
			recursiveParser(line.split("::")[1]); //dejamos la linea como si no tuviera título
		}else if(!answerState && !line.startsWith("{")){ //Texto!
			if(line.contains("{")){ //Si contiene un { es que hay parte de una respuesta en la linea
				recursiveParser(line.substring(0, line.indexOf("{"))); //Cogemos solo el texto de la pregunta y reparseamos
				answerState = true; //Ahora vamos a la respuesta  de la pregunta y activamos el modo respuesta
				recursiveParser(line.substring(line.indexOf("{")+1, line.length())); //parseamos el inicio de la respuesta.
			}
			questions.add(index, new Question()); //Creamos la nueva pregunta!!
			questions.get(index).setQuestion(line); //Añadimos la pregunta al objeto pregunta
		}else if(line.startsWith("{")){ //Si empieaa por  {
			answerState = true; //Entramos en modo respuestas
			if(line.contains("}")) //Si contiene {
				recursiveParser(line.substring(1, line.indexOf("}")));//Obtenemos las respuestas en una linea
			recursiveParser(line.substring(1, line.length())); //Si no hay caracter } o bien no hay nada despues de { o hay respuestas en todo caso reparseamos la linea
		}else if(answerState && !line.contains("{") && !line.contains("}")){
			
			if(line.contains("~")){
				String[] lines = line.split("~");
				for(String str : lines)
					recursiveParser(str);
			}else{
				if(line.contains("=")&& correctYet == false){
					if(!line.startsWith("="))
						recursiveParser(line.substring(0, line.indexOf("=")));
					
					String correct = line.substring(line.indexOf("=")+1, line.length());
					Answer correctAnswer = new Answer();
					correctAnswer.setCorrect(true);
					correctAnswer.setResponse(correct);
					questions.get(index).addAnswer(correctAnswer);
					correctYet = true;
				}else{
					Answer incorrectAnswer = new Answer();
					incorrectAnswer.setCorrect(false);
					incorrectAnswer.setResponse(line);
					questions.get(index).addAnswer(incorrectAnswer);
				}
			}
			
			
			
		}else if(answerState && line.contains("}")){
			if(line.startsWith("}")){ //Final de la pregunta, cambia el question y será null, nueva pregunta
				answerState = false;
				correctYet = false;
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
		log.info("Entrando en parser Gift");
		for(String line : data.split("\n")){
			//System.out.print(line);
			recursiveParser(line);
		}
		return questions;
		
	}
	
	

}
