package es.uniovi.asw.trivial.extractor.parsersystem;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class ParserFile {
	private Stream stream = FactoryService.getIoService().getStreamFile();
	private Parser parser = FactoryService.getParserService().getGiftParser();
	private Logger log = FactoryService.getLogService();
	private List<Question> questions;
	public ParserFile(String pathInputFile, String formatInputFile) {
		log.info("Inicio lectura fichero formato: "+formatInputFile);		// Sentencia Log
		String data = stream.read(pathInputFile);							//Usamos el stream proporcionado por la factorie para leer el fichero.
		log.info("Lectura completada! Caracteres leidos: "+data.length());			// Sentencia Log
		log.info("Inicio de procesado de parser");							// Sentencia Log
		questions = parser.parser(data);						// Obtenemos una lista de Cuestiones con sus respuestas al ejecutar el parser.
		log.info("Parseado completado! número: "+questions.size());									// Sentencia Log					
	}
	public List<Question> getQuestions(){
		return questions;
	}
	
	
}
