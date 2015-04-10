package es.uniovi.asw.game.persistence;

import java.util.ArrayList;

import es.uniovi.asw.trivial.infraestructure.model.Question;

/**
 * Interfaz para definir los metodos disponibles de la base de datos
 * @author María José Sanchez Doria
 *
 */
public interface PersistenceService {

	public ArrayList<Question> getQuestionsCategory(String category);

	public boolean saveUsuario(String login, String passwd, int privilegiado,
			int questionSuccess, int questionsFailed, int matchSuccess,
			int matchFailed);

	public boolean updateUsuarioQuestionsS(String login, int questionSuccess);

	public boolean updateUsuarioQuestionsF(String login, int questionsFailed);

	public boolean updateUsuarioPartidasGanadas(String login, int matchSuccess);

	public boolean updateUsuarioPartidasPerdidas(String login, int matchFailed);
	
	public boolean deleteUsuario(String login);

}
