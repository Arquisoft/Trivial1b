package es.uniovi.asw.trivial.extractor.parsersystem;

import java.util.List;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.extractor.services.serializer.Serializer;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.io.Stream;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class ParserSystemManager {
	private Stream stream = FactoryService.getIoService().getStreamFile();
	private Parser parser = FactoryService.getParserService().getGiftParser();
	private Serializer serializer = FactoryService.getSerializerService().getSerializerJson();
	public static void main(String[] args) {
		new ParserSystemManager();
	}
	public ParserSystemManager() {
		String pathInputFile = "";
		String pathOutputFile = "";
		String formatInputFile = "";
		String formatOutputFile = "";
		
		String data = stream.read(pathInputFile);
		List<Question> questions = parser.parser(data);
		String jsonData = serializer.serialize(questions);
		stream.write(pathOutputFile, jsonData);
		
	}

}
