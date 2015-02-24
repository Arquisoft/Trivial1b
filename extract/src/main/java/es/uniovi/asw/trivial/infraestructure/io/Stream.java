package es.uniovi.asw.trivial.infraestructure.io;

public interface Stream {
	
	public void write(String uri, String data);
	public String read(String uri);

}
