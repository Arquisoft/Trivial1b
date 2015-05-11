import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.uniovi.asw.infraestructura.model.Trivial;
import es.uniovi.asw.persistence.PreguntaDb;


public class PreguntaDbTest {

	@Test
	public void test() {
		Trivial juego = new Trivial();
		juego.sacarPregunta("Geografia");
		assertTrue(juego.sacarPregunta("Geografia")!=null);
		PreguntaDb pdb = new PreguntaDb();
		assertTrue(pdb.lookup("Geografia")!=null);
		System.out.println(pdb.lookup("Geografia").getQuestion());
	}

}
