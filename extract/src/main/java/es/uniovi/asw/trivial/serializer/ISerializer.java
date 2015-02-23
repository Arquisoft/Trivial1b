package main.java.es.uniovi.asw.trivial.serializer;

import java.util.List;

import main.java.es.uniovi.asw.trivial.common.model.Question;

public interface ISerializer {
	
	public String serializer(List<Question> questions);

}
