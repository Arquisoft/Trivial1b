

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import infraestructura.util.ExtractorCoordenadas;
import infraestructura.util.casillas.Figura;

import java.awt.Point;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ExtractorCoordenadasTest {

	@Test
	public void test() {
		ExtractorCoordenadas e = new ExtractorCoordenadas();
		Point p1 = new Point(355,362);
		Point p2 = new Point(340,49);
		Point puntoFuera1 = new Point(342,146);
		Point puntoFuera2 = new Point(26,22);
		Map<Integer, Figura> mapa = e.getMapa();

		Iterator<Entry<Integer, Figura>> it = mapa.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Figura> entry = it.next();
			if (entry.getKey() == 72) {
				assertTrue(entry.getValue().contains(p1));
				assertFalse(entry.getValue().contains(p2));
			} 
			if(entry.getKey() == 0) {
				assertTrue(entry.getValue().contains(p2));
				assertFalse(entry.getValue().contains(p1));
			}
			assertFalse(entry.getValue().contains(puntoFuera1));
			assertFalse(entry.getValue().contains(puntoFuera2));
		}

	}

}
