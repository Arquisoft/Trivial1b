package es.uniovi.asw.trivial.extractor.saversystem;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.parser.ParserService;
import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.model.Question;
import gherkin.lexer.Pa;

public class SaverSystemManager {
	private Stream stream = FactoryService.getIoService().getStreamFile();
	private ParserService serviceParser = FactoryService.getParserService();
	private Serializer serializer = FactoryService.getSerializerService().getSerializerJson();
	
	public static void main(String[] args) {
		new SaverSystemManager(args);
	}

	private String pathInputFile;
	private String pathOutputFile;
	private String formatInputFile;
	private String formatOutputFile;
	public SaverSystemManager(String[] args) {
		inicializateConf(args);
		String jsonData = stream.read(pathInputFile);
		List<Question> questions = serviceParser.getJsonParser().parser(jsonData);
		
		//leer json
		//parsear json -> modelo
		//Conectar Base de datos
		//Actualizar Base de datos.
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
