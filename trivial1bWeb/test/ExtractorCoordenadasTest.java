

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import es.uniovi.asw.infraestructura.util.ExtractorCoordenadas;
import es.uniovi.asw.infraestructura.util.casillas.Figura;

public class ExtractorCoordenadasTest {

	@Test
	public void testContains() {
		ExtractorCoordenadas e = new ExtractorCoordenadas();
		Point p1 = new Point(355,362);
		Point p2 = new Point(340,49);
		Point puntoFuera1 = new Point(342,146);
		Point puntoFuera2 = new Point(26,22);
		Map<Integer, Figura> mapa = e.getMapa();
		
		Point pt = new Point(235,139);
		Point pt2 = new Point(261,64);
		Point pt3 = new Point(508,637);
		Point pt4 = new Point(497,71);
		
		
		Iterator<Entry<Integer, Figura>> it = mapa.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Integer, Figura> entry = it.next();
			
			Figura f = entry.getValue();
			
			
		if(f.contains(pt4))
			assertEquals(entry.getKey(), Integer.valueOf(4));
					
			if(f.contains(pt3))
				assertEquals(entry.getKey(), Integer.valueOf(18));
			if(f.contains(pt2))
				assertEquals(entry.getKey(), Integer.valueOf(40));
			
			if(f.contains(pt))
				assertEquals(entry.getKey(), Integer.valueOf(42));
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
