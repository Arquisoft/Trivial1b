package es.uniovi.asw.game.persistence;

import java.util.List;

import es.uniovi.asw.trivial.infraestructure.model.Question;

public interface PersistenceService {

	public List<Question> getQuestionsCategory(String category);

	public boolean saveUsuario(String login, String passwd, int privilegiado,
			int questionSuccess, int questionsFailed, int matchSuccess,
			int matchFailed);

	public boolean updateUsuarioQuestionsS(String login, int questionSuccess);

	public boolean updateUsuarioQuestionsF(String login, int questionsFailed);

	public boolean updateUsuarioPartidasGanadas(String login, int matchSuccess);

	public boolean updateUsuarioPartidasPerdidas(String login, int matchFailed);
	
	public boolean deleteUsuario(String login);

}
