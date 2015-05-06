

import static org.junit.Assert.*;
import infraestructura.util.ExtractorCoordenadas;
import infraestructura.util.casillas.Figura;

import java.awt.Point;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class ExtractorCoordenadasTest {

	@Test
	public void testContains() {
		ExtractorCoordenadas e = new ExtractorCoordenadas();
		Point p1 = new Point(355,362);
		Point p2 = new Point(340,49);
		Point puntoFuera1 = new Point(342,146);
		Point puntoFuera2 = new Point(26,22);
		Map<Integer, Figura> mapa = e.getMapa();
		
		Iterator<Entry<Integer, Figura>> it = mapa.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Figura> entry = it.next();
			
			Figura f = entry.getValue();
	
			if (entry.getKey() == 72) {
				assertTrue(f.contains(p1));
				assertFalse(f.contains(p2));
			} 
			if(entry.getKey() == 0) {
				assertTrue(f.contains(p2));
				assertFalse(f.contains(p1));
			}
			assertFalse(f.contains(puntoFuera1));
			assertFalse(f.contains(puntoFuera2));
		}

		
	}
	
	@Test
	public void testTipo() {
		
		ExtractorCoordenadas e = new ExtractorCoordenadas();
		Map<Integer, Figura> mapa = e.getMapa();
		int casillasNormales = 0;
		int quesitos = 0;
		int dados = 0; 
		int centrales = 0;
		
		Iterator<Entry<Integer, Figura>> it = mapa.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Figura> entry = it.next();
		Figura f = entry.getValue();
		if(f.isCentral())
			centrales++;
		else if (f.isDado())
			dados++;
		else if(f.isQuesito())
			quesitos++;
		else
			casillasNormales++;
		}
	
	assertEquals(1, centrales);
	assertEquals(12, dados);
	assertEquals(6, quesitos);
	assertEquals(54,casillasNormales);
	}

}
