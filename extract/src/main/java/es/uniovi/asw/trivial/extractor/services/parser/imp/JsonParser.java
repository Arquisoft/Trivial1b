package es.uniovi.asw.trivial.extractor.services.parser.imp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import es.uniovi.asw.trivial.extractor.services.parser.Parser;
import es.uniovi.asw.trivial.infraestructure.factories.FactoryService;
import es.uniovi.asw.trivial.infraestructure.log.impl.Logger;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class JsonParser implements Parser {
	private Logger log = FactoryService.getLogService();
	@Override
	public List<Question> parser(String data) {
		log.info("Entrando en Parser Json");
		List<Question> questions = new ArrayList<Question>();
		try {
			String[] lines = data.split("\n");
			
			for(String line : lines){
				JSONObject obj = new JSONObject(line);
				Question quest = new Question();
				quest.setTitle(obj.getString("title"));
				quest.setQuestion(obj.getString("texto"));
				for(int i= 0; i <obj.getJSONArray("answersTrue").length(); i++){
					Answer ans = new Answer();
					ans.setCorrect(false);
					ans.setResponse((String)obj.getJSONArray("answersTrue").get(i));
					quest.addAnswer(ans);
				}
				for(int i= 0; i <obj.getJSONArray("answersFalse").length(); i++){
					Answer ans = new Answer();
					ans.setCorrect(false);
					ans.setResponse((String)obj.getJSONArray("answersFalse").get(i));
					quest.addAnswer(ans);
				}
				questions.add(quest);
			}
		} catch (JSONException e) {
			log.error("Error con el objeto JSONObject");
		}
		return questions;
		
	}

}
