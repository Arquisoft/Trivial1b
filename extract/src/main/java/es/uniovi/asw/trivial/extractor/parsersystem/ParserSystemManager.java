package es.uniovi.asw.trivial.extractor.parsersystem;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.log.impl.LogLevel;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class ParserSystemManager {
	private Logger log = FactoryService.getLogService();
	//Add defaultFiles
	private String pathInputFile = "X:/ASW/Trivial1b/extract/src/main/resources/preguntasGIFT";//new String[] {"-if=X:/ASW/Trivial1b/extract/src/main/resources/preguntasGIFT" ,"-fi=GIFT"}
	private String pathOutputFile = "./outputQuest";
	private String formatInputFile = ".GIFT";
	private String formatOutputFile = ".json";
	
	public static void main(String[] args) {
		new ParserSystemManager(args);
	}
	public ParserSystemManager(String[] args) {
		log.setLogLevel(LogLevel.ALL);										//Situamos el log level a todos los mensajes.
		
		inicializateConf(args);												//Inicializamos parametros
		
		List<Question> questions =											//Preparamos preguntas. 
				new ParserFile(pathInputFile, formatInputFile)				//Creamos parseador
				.getQuestions();											//Obtenemos preguntas.
		new SerializerFile(pathOutputFile,formatOutputFile,questions);		//Serializamos preguntas
	}
	
	private String argumentProcess(String arg,String var){					
		if(arg.split("=").length != 2)										//Dividimos por = si esto da u número de string distinto de 2 es incorreto el path
			throw new IllegalArgumentException(var+" argument is incorrect");//Lanzamos excepción
		return arg.split("=")[1].trim();									//En caso correcto devolvemos la segunda parte de la división.
	}
	
	private void inicializateConf(String[] args){
		for(String arg : args){												// Para cada parámetro
			if(arg.startsWith("inputFile")|| arg.startsWith("-if"))			//Si empieza por las palabras clave...
				pathInputFile = argumentProcess(arg, "inputFile");			//Procesamos el argumento y lo asignamos a la variable correspondiente
			if(arg.startsWith("outputFile")|| arg.startsWith("-of"))
				pathOutputFile = argumentProcess(arg, "outputFile");
			if(arg.startsWith("formatInput")|| arg.startsWith("-fi"))
				formatInputFile = argumentProcess(arg, "formatInput");
			if(arg.startsWith("formatOutput") || arg.startsWith("-fo") )
				formatOutputFile = argumentProcess(arg, "formatOutput");
		}
	}

}
