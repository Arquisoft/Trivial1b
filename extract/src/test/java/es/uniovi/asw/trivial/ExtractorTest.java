package test.java.es.uniovi.asw.trivial;

import static org.assertj.core.api.Assertions.*;

import main.java.es.uniovi.asw.trivial.Extractor;

import org.junit.Test;

public class ExtractorTest {
	
	@Test
	public void emptyExtractor() {
		String args[] = {};
		Extractor ext = new Extractor();
	    assertThat(ext.run(args)).isEqualTo(0);
	  }

}
