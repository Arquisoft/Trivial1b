package es.uniovi.asw.trivial.extractor.parsersystem;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class SerializerFile {
	private Stream stream = FactoryService.getIoService().getStreamFile();
	private Serializer serializer = FactoryService.getSerializerService().getSerializerJson();
	private Logger log = FactoryService.getLogService();
	
	public SerializerFile(String formatOutputFile,String pathOutputFile, List<Question> questions) {
		log.info("Inicio serialización a "+formatOutputFile);				// Sentencia Log
		String jsonData = serializer.serialize(questions);					//Serializamos la lista de cuestiones y lo convertimose en un super string json
		log.info("Se han serializado las preguntas");						// Sentencia Log
		log.info("Grabando preguntas en fichero "+pathOutputFile);			// Sentencia Log
		stream.write(pathOutputFile, jsonData);								//Y cómo es lógito y natural lo escribimos en un fichero, D:
		log.info("El proceso de conversión a terminado");					// Sentencia Log
	}

}
