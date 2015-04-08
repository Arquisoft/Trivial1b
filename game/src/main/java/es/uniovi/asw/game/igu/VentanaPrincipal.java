package es.uniovi.asw.game.igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.uniovi.asw.game.model.Partida;
/**
 * Clase de prueba
 * @author Ana Isabel Blanco
 *
 */
public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -816303105676299048L;
	private JPanel contentPane;
	private JPanel pnTablero;
	private Component[][] tablero = new Component[9][9];
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAcercaDe;
	private JMenu mnAyuda;
	private JMenu mnConfiguracion;
	private JMenuItem mntmNuevo;
	private JMenuItem mntmSalir;
	private JPanel pnLateral;
	private JPanel pnDado;
	private JPanel pnJugadores;
	private JButton btDado;
	private JLabel lbDado;
	private Color naranja = new Color(255,69,0);
	private Color marron = new Color(139,69,19);
	private Color[] colores1 = {Color.BLUE,naranja, marron, Color.GREEN, Color.BLUE,Color.YELLOW, Color.MAGENTA};
	private Color[] colores2 = {Color.GREEN,Color.MAGENTA,naranja, Color.YELLOW, Color.BLUE, marron};
	private Color[] colores3 = {Color.YELLOW, marron, naranja, Color.MAGENTA,Color.GREEN,Color.BLUE};
	private Color[] colores4 = {Color.MAGENTA, marron, Color.YELLOW,naranja,Color.MAGENTA, Color.BLUE, marron, Color.GREEN, Color.YELLOW,Color.BLUE };
	private int contador1;
	private int contador2;
	private int contador3;
	private int contador4;
	private Partida partida;
	
	
	
	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private DialogLogin dialogLogin;

			public void run() {
				try {
					UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					dialogLogin = new DialogLogin(frame);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		partida = new Partida();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 714);
		initialize();
		inicializaTablero();
		inicializaImagenes();
	}

	private void inicializaImagenes() {
		for(int i=0; i<tablero.length;i++) {
			for(int j=0; j<tablero.length; j++) {
				if (compruebaCoordenadas(i, j)) {
					asociarImagenBotones((JButton) tablero[i][j],i,j);
				}
			}
		}
		
	}

	private void initialize() {
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPnTablero(), BorderLayout.CENTER);
		contentPane.add(getPnLateral(), BorderLayout.EAST);
	}

	private void inicializaTablero() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				JButton bt = new JButton();
				if (compruebaCoordenadas(i, j)) {
					bt.setToolTipText("Click para moverse aquí");
					bt.setActionCommand(i +"-" + j);
					asociarEventoBotones(bt);
					tablero[i][j] = bt;
					pnTablero.add(bt);
				} else {
					JLabel lb = new JLabel();
					tablero[i][j] = lb;
					pnTablero.add(lb);
				}
				
			}
		}

	}

	/**
	 * Asocia las imagenes y los colores a los botones.
	 * @param bt
	 * @param i
	 * @param j
	 */
	private void asociarImagenBotones(JButton bt, int i, int j) {

		if(j==0) { //Para la primera columna
			rellenarPrimeraColumna(bt, i, j);
		}
		else if(j==4) { //Para la columna central
			rellenarSegundaColumna(bt, i, j);			
		} else if(j==8) { //Para la ultima columna
			rellenarTerceraColumna(bt, i, j);			
		} else { //Para el resto de columnas
			if(bt.getBackground()==null) {
				bt.setBackground(colores4[contador4]);
				contador4++;
				System.out.println(contador4);
			}
		}
		
	}

	private void rellenarTerceraColumna(JButton bt, int i, int j) {
		ImageIcon img;
		switch(i) {
		case 0: //Para el quesito naranja, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/naranja.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j-1].setBackground(Color.YELLOW);
			tablero[i+1][j].setBackground(Color.YELLOW);
			break;
		case 4:
			img = new ImageIcon(getClass().getResource("/dado.png"));
			ajustarImagenABoton(img,bt);
			break;
		case 8:  //Para el quesito amarillo, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/amarillo.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j-1].setBackground(naranja);
			tablero[i-1][j].setBackground(naranja);
			break;
		default:
			bt.setBackground(colores3[contador3]);
			contador3++;
			break;
		}
	}

	private void rellenarSegundaColumna(JButton bt, int i, int j) {
		ImageIcon img;
		switch(i) {
		case 0: //Para el quesito marron, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/marron.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j+1].setBackground(Color.GREEN);
			tablero[i+1][j].setBackground(Color.GREEN);
			tablero[i][j-1].setBackground(Color.GREEN);
			break;
		case 4:
			img = new ImageIcon(getClass().getResource("/casillacentral.png"));
			ajustarImagenABoton(img,bt);
			break;
		case 8:  //Para el quesito verde, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/verde.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j+1].setBackground(marron);
			tablero[i-1][j].setBackground(marron);
			tablero[i][j-1].setBackground(marron);
			break;
		default:
			bt.setBackground(colores2[contador2]);
			contador2++;
			break;
		}
	}

	private void rellenarPrimeraColumna(JButton bt, int i, int j) {
		ImageIcon img;
		switch(i) {
		case 0: //Para el quesito rosa, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/rosa.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j+1].setBackground(Color.BLUE);
			tablero[i+1][j].setBackground(Color.BLUE);
			break;
		case 4: 
			img = new ImageIcon(getClass().getResource("/dado.png"));
			ajustarImagenABoton(img,bt);
			break;
		case 8:  //Para el quesito azul, le ponemos la imagen y el color a las casillas adyacentes.
			img = new ImageIcon(getClass().getResource("/azul.png"));
			ajustarImagenABoton(img,bt);
			tablero[i][j+1].setBackground(Color.MAGENTA);
			tablero[i-1][j].setBackground(Color.MAGENTA);
			break;
		default:
			bt.setBackground(colores1[contador1]);
			contador1++;
			break;
		}
	}

	
	private boolean compruebaCoordenadas(int i, int j) {
		if (j == 1 || j == 2 || j == 3 || j == 5 || j == 6 || j == 7) {
			if (i != 1 && i != 2 && i != 3 && i != 5 && i != 6 && i != 7)
				return true;
			else
				return false;
		}
		return true;
	}

	private void asociarEventoBotones(final JButton bt) {
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i =Integer.parseInt(bt.getActionCommand().split("-")[0]);
				int j = Integer.parseInt(bt.getActionCommand().split("-")[1]);
				if(i==4 && j==0 || i==4 && j==8) {
					lbDado.setText(String.valueOf(partida.lanzarDado()));
				} else {
					crearPregunta();
				}
			}
		});
	}

	public void crearPregunta() {
		DialogPregunta dP = new DialogPregunta(this);
		dP.setLocationRelativeTo(this);
		dP.sacarPregunta();
		dP.setVisible(true);
	}

	private JPanel getPnTablero() {
		if (pnTablero == null) {
			pnTablero = new JPanel();
			pnTablero.setPreferredSize(new Dimension(575, 10));
			pnTablero.setMaximumSize(new Dimension(575, 10));
			pnTablero.setBackground(Color.WHITE);
			pnTablero.setForeground(Color.WHITE);
			pnTablero.setLayout(new GridLayout(9, 9, 0, 0));
		}
		return pnTablero;
	}
	
	/**
	 * Modifica el tamaño de la imagen y la pone como icono del botón.
	 * @param img la imagen a redimensionar
	 * @param bt el botón al que se va a asociar la imagen.
	 */
	private void ajustarImagenABoton(ImageIcon img, JButton bt) {
		
		int ancho = 60; // ancho en pixeles que tendra el icono escalado
		int alto = -1; // alto (para que conserve la proporcion pasamos -1)

		// Obtiene un icono en escala con las dimensiones especificadas
		ImageIcon imagenAEscala = new ImageIcon(img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
		bt.setIcon(imagenAEscala);
	}
	
	private void ajustarImagenALabel(ImageIcon img, JLabel lb) {
		
		int ancho =30; // ancho en pixeles que tendra el icono escalado
		int alto = -1; // alto (para que conserve la proporcion pasamos -1)

		// Obtiene un icono en escala con las dimensiones especificadas
		ImageIcon imagenAEscala = new ImageIcon(img.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_DEFAULT));
		lb.setIcon(imagenAEscala);
	}
	
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnConfiguracion());
			menuBar.add(getMnAcercaDe());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu("Juego");
			mnJuego.add(getMntmNuevo());
			mnJuego.add(getMntmSalir());
		}
		return mnJuego;
	}
	private JMenu getMnAcercaDe() {
		if (mnAcercaDe == null) {
			mnAcercaDe = new JMenu("Acerca de");
		}
		return mnAcercaDe;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu("Ayuda");
		}
		return mnAyuda;
	}
	private JMenu getMnConfiguracion() {
		if (mnConfiguracion == null) {
			mnConfiguracion = new JMenu("Configuracion");
		}
		return mnConfiguracion;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem("Nuevo");
		}
		return mntmNuevo;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
		}
		return mntmSalir;
	}
	private JPanel getPnLateral() {
		if (pnLateral == null) {
			pnLateral = new JPanel();
			pnLateral.setLayout(new BorderLayout(0, 0));
			pnLateral.add(getPnDado(), BorderLayout.NORTH);
			pnLateral.add(getPnJugadores(), BorderLayout.CENTER);
		}
		return pnLateral;
	}
	private JPanel getPnDado() {
		if (pnDado == null) {
			pnDado = new JPanel();
			pnDado.setBackground(Color.WHITE);
			pnDado.add(getBtDado());
			pnDado.add(getLbDado());
		}
		return pnDado;
	}
	private JPanel getPnJugadores() {
		if (pnJugadores == null) {
			pnJugadores = new JPanel();
			pnJugadores.setBackground(Color.WHITE);
			pnJugadores.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Jugadores:", TitledBorder.LEADING, TitledBorder.TOP, null, null));	
		}
		
		return pnJugadores;
	}
	
	public void cargarJugadores() {
		if(!partida.getUsuarios().isEmpty()) {
			for(int i=0; i< partida.getUsuarios().size();i++) {
				System.out.println(partida.getUsuarios().size());
				JPanel pnUser = new JPanel();
				pnUser.setLayout(new GridLayout(2, partida.getUsuarios().size()));
				JLabel lbUser = new JLabel();
				ImageIcon img =  new ImageIcon(getClass().getResource("/user" + (i+1) + ".png"));
				ajustarImagenALabel(img, lbUser);
				JPanel pnQuesitos = new JPanel();
				pnQuesitos.setLayout(new GridLayout(6,1));
				pnUser.add(lbUser);
				pnUser.add(pnQuesitos);
				pnJugadores.add(pnUser);
				pnJugadores.revalidate();
				pnJugadores.repaint();
			}
		}
	}
	private JButton getBtDado() {
		if (btDado == null) {
			btDado = new JButton();
			btDado.setBackground(Color.WHITE);
			ajustarImagenABoton(new ImageIcon(getClass().getResource("/dado.png")), btDado);
			btDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lbDado.setText(String.valueOf(partida.lanzarDado()));
				}
			});
		}
		return btDado;
	}
	private JLabel getLbDado() {
		if (lbDado == null) {
			lbDado = new JLabel("2");
			lbDado.setFont(new Font("Lucida Grande", Font.PLAIN, 42));
		}
		return lbDado;
	}



}
