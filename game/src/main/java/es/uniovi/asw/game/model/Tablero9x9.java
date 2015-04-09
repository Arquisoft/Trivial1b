package es.uniovi.asw.game.model;


public class Tablero9x9 {
	Celda[][] tablero = new Celda[9][9];
	String[] categorias = new String[] { "Geografia", "Entretenimiento",
			"Historia", "Literatura", "Ciencia", "Deportes", "Dado", "Final" };

	public Tablero9x9(int numeroJugadores) {
		inicializarTablero(numeroJugadores);
	}

	public Celda[][] getTablero() {
		return tablero;
	}

	public Celda getCeldaTablero(int i, int j) {
		return tablero[i][j];
	}

	public void setCastillo(Celda[][] tablero) {
		this.tablero = tablero;
	}

	public void inicializarTablero(int numeroJugadores) {
		//inciamos todo a null
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = new Celda(i, j,  null, false);
			}
		}

		// INICIALIZAMOS LOS QUESITOS
		tablero[0][0] = new Celda(0, 0,  categorias[0], true);
		tablero[0][4] = new Celda(0, 4,  categorias[1], true);
		tablero[0][8] = new Celda(0, 8,  categorias[2], true);
		tablero[8][0] = new Celda(8, 0,  categorias[3], true);
		tablero[8][4] = new Celda(8, 4,  categorias[4], true);
		tablero[8][8] = new Celda(8, 8,  categorias[5], true);

		// INICIALIZAMOS LOS DADOS
		tablero[4][0] = new Celda(4, 0,  categorias[6], false);
		tablero[4][8] = new Celda(4, 8,  categorias[6], false);

		// INICIALIZAMOS EL CENTRO (incluir todos los jugadores!!!!)
		tablero[4][4] = new Celda(4, 4,  categorias[7], false);

		// INICIALIZAMOS EL RESTO DE CELDAS
		// fila 0
		tablero[0][1] = new Celda(0, 1,  categorias[4], false);
		tablero[0][2] = new Celda(0, 2,  categorias[2], false);
		tablero[0][3] = new Celda(0, 3,  categorias[5], false);
		tablero[0][5] = new Celda(0, 5,  categorias[3], false);
		tablero[0][6] = new Celda(0, 6,  categorias[0], false);
		tablero[0][7] = new Celda(0, 7,  categorias[4], false);

		// fila 1
		tablero[1][0] = new Celda(1, 0,  categorias[3], false);
		tablero[1][4] = new Celda(1, 4,  categorias[4], false);
		tablero[1][8] = new Celda(1, 8,  categorias[5], false);

		// fila 2
		tablero[2][0] = new Celda(2, 0,  categorias[2], false);
		tablero[2][4] = new Celda(2, 4,  categorias[0], false);
		tablero[2][8] = new Celda(2, 8,  categorias[5], false);

		// fila 3
		tablero[3][0] = new Celda(3, 0,  categorias[1], false);
		tablero[3][4] = new Celda(3, 4,  categorias[2], false);
		tablero[3][8] = new Celda(3, 8,  categorias[1], false);

		// fila 4
		tablero[4][1] = new Celda(4, 1,  categorias[3], false);
		tablero[4][2] = new Celda(4, 2,  categorias[0], false);
		tablero[4][3] = new Celda(4, 3,  categorias[4], false);
		tablero[4][5] = new Celda(4, 5,  categorias[1], false);
		tablero[4][6] = new Celda(4, 6,  categorias[5], false);
		tablero[4][7] = new Celda(4, 7,  categorias[2], false);

		// fila 5
		tablero[5][0] = new Celda(5, 0,  categorias[4], false);
		tablero[5][4] = new Celda(5, 4,  categorias[3], false);
		tablero[5][8] = new Celda(5, 8,  categorias[4], false);

		// fila 6
		tablero[6][0] = new Celda(6, 0,  categorias[5], false);
		tablero[6][4] = new Celda(6, 4,  categorias[5], false);
		tablero[6][8] = new Celda(6, 8,  categorias[3], false);

		// fila 7
		tablero[7][0] = new Celda(7, 0,  categorias[0], false);
		tablero[7][4] = new Celda(7, 4,  categorias[1], false);
		tablero[7][8] = new Celda(7, 8,  categorias[2], false);

		// fila 8
		tablero[8][1] = new Celda(8, 1,  categorias[1], false);
		tablero[8][2] = new Celda(8, 2,  categorias[5], false);
		tablero[8][3] = new Celda(8, 3,  categorias[2], false);
		tablero[8][5] = new Celda(8, 5,  categorias[0], false);
		tablero[8][6] = new Celda(8, 6,  categorias[3], false);
		tablero[8][7] = new Celda(8, 7,  categorias[1], false);
	}
}
