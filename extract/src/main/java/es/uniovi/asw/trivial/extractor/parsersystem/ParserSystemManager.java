package es.uniovi.asw.trivial.extractor.parsersystem;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.log.Log;
import es.uniovi.asw.trivial.infraestructure.log.LogLevel;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class ParserSystemManager {
	private Stream stream = FactoryService.getIoService().getStreamFile();
	private Parser parser = FactoryService.getParserService().getGiftParser();
	private Serializer serializer = FactoryService.getSerializerService().getSerializerJson();
	//Add defaultFiles
	private String pathInputFile = "X:/ASW/Trivial1b/extract/src/main/resources/preguntasGIFT";//new String[] {"-if=X:/ASW/Trivial1b/extract/src/main/resources/preguntasGIFT" ,"-fi=GIFT"}
	private String pathOutputFile = "./outputQuest";
	private String formatInputFile = ".GIFT";
	private String formatOutputFile = ".json";
	
	public static void main(String[] args) {
		Log.setLogLevel(LogLevel.ALL);
		new ParserSystemManager(args);
	}
	public ParserSystemManager(String[] args) {
		inicializateConf(args);												//Inicializamos los parámetros.
		Log.info("Inicio lectura fichero formato: "+formatInputFile);		// Sentencia Log
		String data = stream.read(pathInputFile);							//Usamos el strem proporcionado por la factorie para leer el fichero.
		Log.info("Lectura completada! Caracteres leidos: "+data.length());									// Sentencia Log
		Log.info("Inicio de procesado de parser");							// Sentencia Log
		List<Question> questions = parser.parser(data);						// Obtenemos una lista de Cuestiones con sus respuestas al ejecutar el parser.
		Log.info("Parseado completado! número: "+questions.size());									// Sentencia Log					
		Log.info("Inicio serialización a "+formatOutputFile);				// Sentencia Log
		String jsonData = serializer.serialize(questions);					//Serializamos la lista de cuestiones y lo convertimose en un super string json
		Log.info("Se han serializado las preguntas");						// Sentencia Log
		Log.info("Grabando preguntas en fichero "+pathOutputFile);			// Sentencia Log
		stream.write(pathOutputFile, jsonData);								//Y cómo es lógito y natural lo escribimos en un fichero, D:
		Log.info("El proceso de conversión a terminado");					// Sentencia Log
		
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
