package main.java.es.uniovi.asw.trivial.common.io;

import java.util.List;

public interface FileService {
	
	public String readFile(String path);
	public void writeFile(String path, List<String> list);

}
