package es.uniovi.asw.game.model;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.game.model.User;
import es.uniovi.asw.game.persistence.PreguntaDb;
import es.uniovi.asw.trivial.infraestructure.model.Question;

public class Trivial {
	
	private int numDado;
	private Tablero9x9 tablero9=null;
	private int turno;
	private ArrayList<User> usuarios = new ArrayList<User>();

	private boolean[][] boleans;
	private List<String> mapa;
	
	private PreguntaDb preguntas = new PreguntaDb();

	public ArrayList<User> getUsuarios() {
		return usuarios;
	}
	
	public List<String> getMapa(){
		return mapa;
	}

	public void setUsuarios(ArrayList<User> usuarios) {
		this.usuarios = usuarios;
	}
		
	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	/**
	 * M�todo que devuelve el n�mero del dado
	 * @return numDado
	 */
	public int getNumDado() {
		return numDado;
	}
	/**
	 * M�todo que modifica el nuemero del dado
	 * @param numDado, nuevo numero de dado
	 */
	public void setNumDado(int numDado) {
		this.numDado = numDado;
	}
	
	/**
	 * M�todo que devuelve el objeto tablero
	 * @return tablero
	 */
	public Tablero9x9 getTablero9x9() {
		return tablero9;
	}
	
	public Question sacarPregunta(int i, int j){
		return preguntas.lookup(getTablero9x9().getCeldaTablero(i, j).getCategoria());
	}
	
	public Question sacarPregunta(String categoria){
		return preguntas.lookup(categoria);
	}
	
	/**
	 * M�todo que actualiza el tablero
	 * @param tablero, nuevo tablero
	 */
	public void setTablero9x9(Tablero9x9 tablero9) {
		this.tablero9 = tablero9;
	}
	
	public Trivial(Tablero9x9 tablero9){
		setTablero9x9(tablero9);
		this.turno = 0;
		
		iniciarMatriz();
	}
	
	public void iniciarMatriz(){
		this.boleans = new boolean[][]{{false, false, false, false, false, false, false, false, false},
										{false, true, true, true, false, true, true, true, false},
										{false, true, true, true, false, true, true, true, false},
										{false, true, true, true, false, true, true, true, false},
										{false, false, false, false, false, false, false, false, false},
										{false, true, true, true, false, true, true, true, false},
										{false, true, true, true, false, true, true, true, false},
										{false, true, true, true, false, true, true, true, false},
										{false, false, false, false, false, false, false, false, false}};
	}
	
	public void iniciarHash(){
		this.mapa = new ArrayList<String>();
	}
		
	public User getSiguienteJugador(){
		if(turno < usuarios.size()-1){
			turno++;
		}else{
			turno = 0;
		}
		return usuarios.get(turno);
	}

	public void mostrarTodosLosPosiblesCaminos(User juega, int dado){
		iniciarMatriz();
		iniciarHash();
		int fila = juega.getCelda().getFila();
		int columna = juega.getCelda().getColumna();
				
		calcularCaminos(fila, columna, boleans, 0, dado);
	}
	
	public void calcularCaminos(int iinicial, int jinicial, boolean[][] bol, int pasos, int dado) {
//		iniciarMatriz();
//		iniciarHash();
//		iniciarCamino();
		
		bol[iinicial][jinicial] = true;
		
		int iaux = iinicial;
		int jaux = jinicial;
		int paux = pasos;
		
		if(pasos == dado){
//			System.out.println(iinicial + "-" + jinicial);
//			for(int i = 0; i<bol.length; i++){
//				for(int j = 0; j<bol.length; j++){
//					System.out.print(bol[i][j] + "\t");
//				}
//				System.out.println();
//			}
			String value = iinicial + "-" + jinicial;
			
			mapa.add(value);
		}
		else{
			//DERECHA
			if(jaux+1 <= bol.length-1 &&  bol[iaux][jaux+1]==false){
				calcularCaminos(iaux, jaux+1, bol, paux+1, dado);
				bol[iaux][jaux+1] = false;
				iaux = iinicial;
				jaux = jinicial;
				paux = pasos;
			}
			if(jaux > 0 && bol[iaux][jaux-1]==false){
				calcularCaminos(iaux, jinicial-1, bol, paux+1, dado);
				bol[iaux][jinicial-1] = false;
				iaux = iinicial;
				jaux = jinicial;
				paux = pasos;
			}
			if(iaux > 0 && bol[iaux-1][jaux]==false){
				calcularCaminos(iaux-1, jaux, bol, paux+1, dado);
				bol[iaux-1][jaux] = false;
				iaux = iinicial;
				jaux = jinicial;
				paux = pasos;
			}
			if(iaux+1 <= bol.length-1 && bol[iaux+1][jaux]==false){
				calcularCaminos(iaux+1, jaux, bol, paux+1, dado);
				bol[iaux+1][jaux] = false;	
				iaux = iinicial;
				jaux = jinicial;
				paux = pasos;
			}
		}		
	}

//	
//	public boolean isJugadaPosible(int i, int j){
//		User juega = usuarios.get(turno);
//		
//		if(tablero9.getCeldaTablero(i, j).getCategoria() == null){
//			return false;
//		}else{
//			return recorridoEnProfundidad(i,j,juega,numDado);
//		}
//	}
	
	//este metodo es un alternativo el de caminos posibles
//	public boolean recorridoEnProfundidad(int i, int j, Jugador juega, int dado) {
//		iniciarMatriz();
//		int fila = juega.getCelda().getFila();
//		int columna = juega.getCelda().getColumna();
//		
//		int res =  distancia(fila, columna, i, j, boleans, dado);
//		
//		if(res == dado){
//			return true;
//		}
//		return false;
//	}

	//recibe la posicion en la que estas y la posiciona a la que quieres llegar
	//devuelve los pasos minimos que tienes que dar para llegar a esa posicion
	//cuando vuelves compruebas si coinciden con los del dado!
	//FALLA EN EL CASO DE (8, 3) => (4, 3) Y DERIVADOS, ARREGLAR!!!!
	//^^^^^ SOLUCIONADO, NO TOCAR ESTE METODO POR NADA DEL MUNDO!
	//este metodo es un alternativo el de caminos posibles
//	public int distancia(int iinicial, int jinicial, int ifinal, int jfinal, boolean[][] bol, int pasos) {
//		
//		bol[iinicial][jinicial] = true;
//		
////		comprobarCasosRaros(iinicial, jinicial, ifinal, jfinal, bol, pasos);
//		
//		
//		int auxi = iinicial;
//		int auxj = jinicial;
//		
//		//COMPROBACION DE QUE NO SEA UN CASO RARO
//		if((auxi % 2 != 0) && (auxi == ifinal) && (auxj+4 == jfinal || auxj-4 == jfinal)){
//			if(auxi == 1 || auxi == 5){
//				return distancia(iinicial-1, jinicial, ifinal, jfinal, bol, pasos+1);
//			}
//			else{
//				return distancia(iinicial+1, jinicial, ifinal, jfinal, bol, pasos+1);
//			}
//		}
//		
//		if((auxj % 2 != 0) && (auxj == jfinal) && (auxi+4 == ifinal || auxi-4 == ifinal)){
//			if(auxj == 1 || auxj == 5){
//				return distancia(iinicial, jinicial-1, ifinal, jfinal, bol, pasos+1);
//			}
//			else{
//				return distancia(iinicial, jinicial+1, ifinal, jfinal, bol, pasos+1);
//			}
//		}
//		//COMPROBACION DE QUE NO SEA UN CASO RARO FIN
//		
//		int auximas = iinicial;
//		int auximenos = iinicial;
//		int auxjmas = jinicial;
//		int auxjmenos = jinicial;
//		
//		double derecha = Double.MAX_VALUE;
//		double izquierda = Double.MAX_VALUE;
//		double arriba = Double.MAX_VALUE;
//		double abajo = Double.MAX_VALUE;
//		
//		
//		if(iinicial == ifinal && jinicial == jfinal){
//			return pasos;
//		}
//		else{
//						
//			if(auxjmas < bol.length-1 &&  bol[iinicial][auxjmas+1]==false){
//				derecha = Math.sqrt( Math.pow( (iinicial - ifinal), 2 ) + Math.pow(((auxjmas+1) - jfinal), 2));
//			}
//			if(auxjmenos > 0 && bol[iinicial][auxjmenos-1]==false){
//				izquierda = Math.sqrt( Math.pow( (iinicial - ifinal), 2 ) + Math.pow(((auxjmenos-1)- jfinal), 2));
//			}
//			if(auximenos > 0 && bol[auximenos-1][jinicial]==false){
//				arriba= Math.sqrt( Math.pow( ((auximenos-1) - ifinal), 2 ) + Math.pow((jinicial - jfinal), 2));
//			}
//			if(auximas < bol.length-1 && bol[auximas+1][jinicial]==false){
//				abajo = Math.sqrt( Math.pow( ((auximas+1) - ifinal), 2 ) + Math.pow((jinicial - jfinal), 2));			
//			}
//			
//			int res = minimo(derecha, izquierda, arriba, abajo);
//			
//			switch(res){
//				case 0:
//					auxj = jinicial+1;
//					break;
//				case 1:
//					auxj = jinicial-1;
//					break;
//				case 2:
//					auxi = iinicial-1;
//					break;
//				case 3:
//					auxi = iinicial+1;
//					break;
//			}
//			return distancia(auxi, auxj, ifinal, jfinal, bol, pasos+1);
//		}
//	}


//	private int minimo(double derecha, double izquierda, double arriba, double abajo){		
//		double aux;
//		int res = 0;
//		if(derecha < izquierda){
//			aux = derecha;
//			res = 0;
//		}else{
//			aux = izquierda;
//			res = 1;
//		}
//		if(aux > arriba){
//			aux = arriba;
//			res = 2;
//		}
//		if(aux > abajo){
//			aux = abajo;
//			res = 3;
//		}
//		return res;
//	}
	
}
