package es.uniovi.asw.trivial;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import es.uniovi.asw.trivial.extractor.parsersystem.ParserSystemManager;

public class ExtractorTest {
	
	@Test
	public void emptyExtractor() {
		String args[] = {};
		Extractor ext = new Extractor();
	    assertThat(ext.run(args)).isEqualTo(0);
	   
	  }
	@Test
	public void parserGift(){
		new ParserSystemManager(new String[] {"-if=./src/main/resources/preguntasGIFT" ,"-fi=GIFT"});
	}
	
	

}
