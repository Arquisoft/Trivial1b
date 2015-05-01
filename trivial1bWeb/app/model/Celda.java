package model;

public class Celda {
	
	private int fila;
	private int columna;
	private String categoria;
	private boolean quesito;
	
	public Celda(int fila, int columna, String categoria, boolean quesito) {
		setFila(fila);
		setColumna(columna);
		setCategoria(categoria);
		setQuesito(quesito);
	}
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		this.fila = fila;
	}
	
	public int getColumna() {
		return columna;
	}
	
	public void setColumna(int columna) {
		this.columna = columna;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public boolean getQuesito(){
		return quesito;
	}
	
	public void setQuesito(boolean quesito){
		this.quesito = quesito;
	}
}
