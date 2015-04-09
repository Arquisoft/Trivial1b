package es.uniovi.asw.game.igu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.game.model.Celda;
import es.uniovi.asw.game.model.Dado;
import es.uniovi.asw.game.model.Tablero9x9;
import es.uniovi.asw.game.model.Trivial;
import es.uniovi.asw.game.model.User;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelTitulo;
	private JPanel panelJugadores1;
	private JPanel panelTablero;
	private JPanel panelJugadores2;
	private JLabel lblTitulo;
	private JPanel panelJugador1;
	private JLabel lblJugador1;
	private JPanel panelJugador2;
	private JLabel lblJugador2;
	private JPanel panelJugador3;
	private JLabel lblJugador3;
	private JPanel panelJugador4;
	private JLabel lblJugador4;
	private JPanel panelJugador5;
	private JLabel lblJugador5;
	private JPanel panelJugador6;
	private JLabel lblJugador6;
	private JPanel panelTableroCentral;
	private JButton btn00;
	private JButton btn10;
	private JButton btn20;
	private JButton btn30;
	private JButton btn40;
	private JButton btn50;
	private JButton btn60;
	private JButton btn70;
	private JButton btn80;
	private JPanel panelTablero0;
	private JPanel panelTablero1;
	private JButton btn01;
	private JButton btn11;
	private JButton btn21;
	private JButton btn31;
	private JButton btn41;
	private JButton btn51;
	private JButton btn61;
	private JButton btn71;
	private JButton btn81;
	private JPanel panelTablero2;
	private JButton btn02;
	private JButton btn12;
	private JButton btn22;
	private JButton btn32;
	private JButton btn42;
	private JButton btn52;
	private JButton btn62;
	private JButton btn72;
	private JButton btn82;
	private JPanel panelTablero3;
	private JButton btn03;
	private JButton btn13;
	private JButton btn23;
	private JButton btn33;
	private JButton btn43;
	private JButton btn53;
	private JButton btn63;
	private JButton btn73;
	private JButton btn83;
	private JPanel panelTablero4;
	private JButton btn04;
	private JButton btn14;
	private JButton btn24;
	private JButton btn34;
	private JButton btn44;
	private JButton btn54;
	private JButton btn64;
	private JButton btn74;
	private JButton btn84;
	private JPanel panelTablero5;
	private JButton btn05;
	private JButton btn15;
	private JButton btn25;
	private JButton btn35;
	private JButton btn45;
	private JButton btn55;
	private JButton btn65;
	private JButton btn75;
	private JButton btn85;
	private JPanel panelTablero6;
	private JButton btn06;
	private JButton btn16;
	private JButton btn26;
	private JButton btn36;
	private JButton btn46;
	private JButton btn56;
	private JButton btn66;
	private JButton btn76;
	private JButton btn86;
	private JPanel panelTablero7;
	private JButton btn07;
	private JButton btn17;
	private JButton btn27;
	private JButton btn37;
	private JButton btn47;
	private JButton btn57;
	private JButton btn67;
	private JButton btn77;
	private JButton btn87;
	private JPanel panelTablero8;
	private JButton btn08;
	private JButton btn18;
	private JButton btn28;
	private JButton btn38;
	private JButton btn48;
	private JButton btn58;
	private JButton btn68;
	private JButton btn78;
	private JButton btn88;
	private JPanel panelBtn1Arriba;
	private JPanel panelBtn1Abajo;
	private JButton btnA1;
	private JButton btnR1;
	private JButton btnAm1;
	private JButton btnM1;
	private JButton btnV1;
	private JButton btnN1;
	private JPanel panelBtn2Arriba;
	private JButton btnA2;
	private JButton btnR2;
	private JButton btnAm2;
	private JPanel panelBtn2Abajo;
	private JButton btnM2;
	private JButton btnV2;
	private JButton btnN2;
	private JPanel panelBtn3Arriba;
	private JButton btnA3;
	private JButton btnR3;
	private JButton btnAm3;
	private JPanel panelBtn3Abajo;
	private JButton btnM3;
	private JButton btnV3;
	private JButton btnN3;
	private JPanel panelBtn4Arriba;
	private JButton btnA4;
	private JButton btnR4;
	private JButton btnAm4;
	private JPanel panelBtn4Abajo;
	private JButton btnM4;
	private JButton btnV4;
	private JButton btnN4;
	private JPanel panelBtn5Arriba;
	private JButton btnA5;
	private JButton btnR5;
	private JButton btnAm5;
	private JPanel panelBtn5Abajo;
	private JButton btnM5;
	private JButton btnV5;
	private JButton btnN5;
	private JPanel panelBtn6Arriba;
	private JButton btnA6;
	private JButton btnR6;
	private JButton btnAm6;
	private JPanel panelBtn6Abajo;
	private JButton btnM6;
	private JButton btnV6;
	private JButton btnN6;

	// COLORES
	private Color azul = new Color(51, 204, 255);
	private Color rosa = new Color(255, 102, 204);
	private Color amarillo = Color.yellow;
	private Color marron = new Color(153, 102, 51);
	private Color verde = new Color(0, 102, 51);
	private Color naranja = new Color(255, 102, 0);

	private JButton[] quesitosjugador1 = new JButton[6];
	private JButton[] quesitosjugador2 = new JButton[6];
	private JButton[] quesitosjugador3 = new JButton[6];
	private JButton[] quesitosjugador4 = new JButton[6];
	private JButton[] quesitosjugador5 = new JButton[6];
	private JButton[] quesitosjugador6 = new JButton[6];

	private Map<String, JButton[]> mapaQuesitos = new HashMap<String, JButton[]>();
	private int dado = -1;
	private Tablero9x9 tablero;
	private Trivial trivial;
	
	private JButton[][] tabla = new JButton[9][9];
	private JPanel panelDado;
	private JButton btnDado;
	private JLabel lblDado;
	
	private int turnoVentana;
	
	private int numeroJugadores;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private DialogLogin dialogLogin;
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
//					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.ChallengerDeepSkin");
//					SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenSkin");
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
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
		setTitle("TRIVIAL1B");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				VentanaPrincipal.class.getResource("/casillacentral.png")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(200, 10, 1000, 700);
		this.setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(30, 30));
		contentPane.add(getPanelTitulo(), BorderLayout.NORTH);
		contentPane.add(getPanelJugadores1(), BorderLayout.WEST);
		contentPane.add(getPanelTablero(), BorderLayout.CENTER);
		contentPane.add(getPanelJugadores2(), BorderLayout.EAST);
		
		tablero = new Tablero9x9(getJugadores());
		
		trivial = new Trivial(tablero);	
		
		turnoVentana = trivial.getTurno();
		
//		btnA1.setOpaque(true);
	}

	private JPanel getPanelTitulo() {
		if (panelTitulo == null) {
			panelTitulo = new JPanel();
			panelTitulo.setLayout(new GridLayout(1, 2, 0, 0));
			panelTitulo.add(getLblTitulo());
			panelTitulo.add(getPanelDado());
		}
		return panelTitulo;
	}

	private JPanel getPanelJugadores1() {
		if (panelJugadores1 == null) {
			panelJugadores1 = new JPanel();
			panelJugadores1.setLayout(new GridLayout(3, 1, 0, 50));
			panelJugadores1.add(getPanelJugador1());
			panelJugadores1.add(getPanelJugador2());
			panelJugadores1.add(getPanelJugador3());
		}
		return panelJugadores1;
	}

	private JPanel getPanelTablero() {
		if (panelTablero == null) {
			panelTablero = new JPanel();
			panelTablero.setLayout(new BorderLayout(0, 0));
			panelTablero.add(getPanelTableroCentral(), BorderLayout.CENTER);
		}
		return panelTablero;
	}

	private JPanel getPanelJugadores2() {
		if (panelJugadores2 == null) {
			panelJugadores2 = new JPanel();
			panelJugadores2.setLayout(new GridLayout(3, 3, 0, 50));
			panelJugadores2.add(getPanelJugador4());
			panelJugadores2.add(getPanelJugador5());
			panelJugadores2.add(getPanelJugador6());
		}
		return panelJugadores2;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("AQUI VA EL TITULO");
			lblTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 24));
		}
		return lblTitulo;
	}

	private JPanel getPanelJugador1() {
		if (panelJugador1 == null) {
			panelJugador1 = new JPanel();
			panelJugador1.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador1.add(getLblJugador1());
			panelJugador1.add(getPanelBtn1Arriba());
			panelJugador1.add(getPanelBtn1Abajo());
			panelJugador1.setVisible(false);
		}
		return panelJugador1;
	}

	private JLabel getLblJugador1() {
		if (lblJugador1 == null) {
			lblJugador1 = new JLabel("Aqui va el Jugador1");
			lblJugador1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		}
		return lblJugador1;
	}

	private JPanel getPanelJugador2() {
		if (panelJugador2 == null) {
			panelJugador2 = new JPanel();
			panelJugador2.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador2.add(getLblJugador2());
			panelJugador2.add(getPanelBtn2Arriba());
			panelJugador2.add(getPanelBtn2Abajo());
			panelJugador2.setVisible(false);
		}
		return panelJugador2;
	}

	private JLabel getLblJugador2() {
		if (lblJugador2 == null) {
			lblJugador2 = new JLabel("Aqui va el Jugador2");
			lblJugador2.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		}
		return lblJugador2;
	}

	private JPanel getPanelJugador3() {
		if (panelJugador3 == null) {
			panelJugador3 = new JPanel();
			panelJugador3.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador3.add(getLblJugador3());
			panelJugador3.add(getPanelBtn3Arriba());
			panelJugador3.add(getPanelBtn3Abajo());
			panelJugador3.setVisible(false);
		}
		return panelJugador3;
	}

	private JLabel getLblJugador3() {
		if (lblJugador3 == null) {
			lblJugador3 = new JLabel("Aqui va el Jugador3");
			lblJugador3.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		}
		return lblJugador3;
	}

	private JPanel getPanelJugador4() {
		if (panelJugador4 == null) {
			panelJugador4 = new JPanel();
			panelJugador4.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador4.add(getLblJugador4());
			panelJugador4.add(getPanelBtn4Arriba());
			panelJugador4.add(getPanelBtn4Abajo());
			panelJugador4.setVisible(false);
		}
		return panelJugador4;
	}

	private JLabel getLblJugador4() {
		if (lblJugador4 == null) {
			lblJugador4 = new JLabel("Aqui va el Jugador4");
			lblJugador4.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		}
		return lblJugador4;
	}

	private JPanel getPanelJugador5() {
		if (panelJugador5 == null) {
			panelJugador5 = new JPanel();
			panelJugador5.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador5.add(getLblJugador5());
			panelJugador5.add(getPanelBtn5Arriba());
			panelJugador5.add(getPanelBtn5Abajo());
			panelJugador5.setVisible(false);
		}
		return panelJugador5;
	}

	private JLabel getLblJugador5() {
		if (lblJugador5 == null) {
			lblJugador5 = new JLabel("Aqui va el Jugador5");
			lblJugador5.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		}
		return lblJugador5;
	}

	private JPanel getPanelJugador6() {
		if (panelJugador6 == null) {
			panelJugador6 = new JPanel();
			panelJugador6.setLayout(new GridLayout(3, 1, 0, 0));
			panelJugador6.add(getLblJugador6());
			panelJugador6.add(getPanelBtn6Arriba());
			panelJugador6.add(getPanelBtn6Abajo());
			panelJugador6.setVisible(false);
		}
		return panelJugador6;
	}

	private JLabel getLblJugador6() {
		if (lblJugador6 == null) {
			lblJugador6 = new JLabel("Aqui va el Jugador6");
			lblJugador6.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		}
		return lblJugador6;
	}

	private JPanel getPanelTableroCentral() {
		if (panelTableroCentral == null) {
			panelTableroCentral = new JPanel();
			panelTableroCentral.setLayout(new GridLayout(1, 9, 0, 0));
			panelTableroCentral.add(getPanelTablero0());
			panelTableroCentral.add(getPanelTablero1());
			panelTableroCentral.add(getPanelTablero2());
			panelTableroCentral.add(getPanelTablero3());
			panelTableroCentral.add(getPanelTablero4());
			panelTableroCentral.add(getPanelTablero5());
			panelTableroCentral.add(getPanelTablero6());
			panelTableroCentral.add(getPanelTablero7());
			panelTableroCentral.add(getPanelTablero8());
		}
		return panelTableroCentral;
	}

	private JButton getBtn00() {
		if (btn00 == null) {
			btn00 = new JButton("");
			btn00.setOpaque(false);
			btn00.setFocusPainted(false);
			btn00.setToolTipText("Quesito de Geograf\u00EDa");

			redimensionarImagenes(btn00, "/azul.png", 65, 55);

			btn00.setActionCommand("0-0");
		}
		return btn00;
	}

	private JButton getBtn10() {
		if (btn10 == null) {
			btn10 = new JButton("");
			btn10.setActionCommand("1-0");
			btn10.setBackground(marron);
		}
		return btn10;
	}

	private JButton getBtn20() {
		if (btn20 == null) {
			btn20 = new JButton("");
			btn20.setActionCommand("2-0");
			btn20.setBackground(amarillo);
		}
		return btn20;
	}

	private JButton getBtn30() {
		if (btn30 == null) {
			btn30 = new JButton("");
			btn30.setActionCommand("3-0");
			btn30.setBackground(rosa);
		}
		return btn30;
	}

	private JButton getBtn40() {
		if (btn40 == null) {
			btn40 = new JButton("");
			btn40.setToolTipText("Vuelva a tirar");
			
			String url = "/dado2.png";
			redimensionarImagenes(btn40, url , 75,65);
			
//			btn40.setIcon(new ImageIcon(VentanaPrincipal9x9.class.getResource("/imagenes/dados/dado2.png")));
			btn40.setActionCommand("4-0");
			btn40.setBackground(Color.white);
		}
		return btn40;
	}

	private JButton getBtn50() {
		if (btn50 == null) {
			btn50 = new JButton("");
			btn50.setActionCommand("5-0");
			btn50.setBackground(verde);
		}
		return btn50;
	}

	private JButton getBtn60() {
		if (btn60 == null) {
			btn60 = new JButton("");
			btn60.setActionCommand("6-0");
			btn60.setBackground(naranja);
		}
		return btn60;
	}

	private JButton getBtn70() {
		if (btn70 == null) {
			btn70 = new JButton("");
			btn70.setActionCommand("7-0");
			btn70.setBackground(azul);
		}
		return btn70;
	}

	private JButton getBtn80() {
		if (btn80 == null) {
			btn80 = new JButton("");
			btn80.setOpaque(false);
			btn80.setFocusPainted(false);
			btn80.setToolTipText("Quesito de Arte y Literatura");

			redimensionarImagenes(btn80,
					"/marron.png", 65, 55);

			btn80.setActionCommand("8-0");
		}
		return btn80;
	}

	private JPanel getPanelTablero0() {
		if (panelTablero0 == null) {
			panelTablero0 = new JPanel();
			panelTablero0.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero0.add(getBtn00());
			panelTablero0.add(getBtn10());
			panelTablero0.add(getBtn20());
			panelTablero0.add(getBtn30());
			panelTablero0.add(getBtn40());
			panelTablero0.add(getBtn50());
			panelTablero0.add(getBtn60());
			panelTablero0.add(getBtn70());
			panelTablero0.add(getBtn80());
		}
		return panelTablero0;
	}

	private JPanel getPanelTablero1() {
		if (panelTablero1 == null) {
			panelTablero1 = new JPanel();
			panelTablero1.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero1.add(getBtn01());
			panelTablero1.add(getBtn11());
			panelTablero1.add(getBtn21());
			panelTablero1.add(getBtn31());
			panelTablero1.add(getBtn41());
			panelTablero1.add(getBtn51());
			panelTablero1.add(getBtn61());
			panelTablero1.add(getBtn71());
			panelTablero1.add(getBtn81());
		}
		return panelTablero1;
	}

	private JButton getBtn01() {
		if (btn01 == null) {
			btn01 = new JButton("");
			btn01.setActionCommand("0-1");
			btn01.setBackground(verde);
		}
		return btn01;
	}

	private JButton getBtn11() {
		if (btn11 == null) {
			btn11 = new JButton("");
			btn11.setVisible(false);
			btn11.setEnabled(false);
			btn11.setActionCommand("1-1");
		}
		return btn11;
	}

	private JButton getBtn21() {
		if (btn21 == null) {
			btn21 = new JButton("");
			btn21.setVisible(false);
			btn21.setEnabled(false);
			btn21.setActionCommand("2-1");
		}
		return btn21;
	}

	private JButton getBtn31() {
		if (btn31 == null) {
			btn31 = new JButton("");
			btn31.setVisible(false);
			btn31.setEnabled(false);
			btn31.setActionCommand("3-1");
		}
		return btn31;
	}

	private JButton getBtn41() {
		if (btn41 == null) {
			btn41 = new JButton("");
			btn41.setActionCommand("4-1");
			btn41.setBackground(marron);
		}
		return btn41;
	}

	private JButton getBtn51() {
		if (btn51 == null) {
			btn51 = new JButton("");
			btn51.setVisible(false);
			btn51.setEnabled(false);
			btn51.setActionCommand("5-1");
		}
		return btn51;
	}

	private JButton getBtn61() {
		if (btn61 == null) {
			btn61 = new JButton("");
			btn61.setVisible(false);
			btn61.setEnabled(false);
			btn61.setActionCommand("6-1");
		}
		return btn61;
	}

	private JButton getBtn71() {
		if (btn71 == null) {
			btn71 = new JButton("");
			btn71.setVisible(false);
			btn71.setEnabled(false);
			btn71.setActionCommand("7-1");
		}
		return btn71;
	}

	private JButton getBtn81() {
		if (btn81 == null) {
			btn81 = new JButton("");
			btn81.setActionCommand("8-1");
			btn81.setBackground(rosa);
		}
		return btn81;
	}

	private JPanel getPanelTablero2() {
		if (panelTablero2 == null) {
			panelTablero2 = new JPanel();
			panelTablero2.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero2.add(getBtn02());
			panelTablero2.add(getBtn12());
			panelTablero2.add(getBtn22());
			panelTablero2.add(getBtn32());
			panelTablero2.add(getBtn42());
			panelTablero2.add(getBtn52());
			panelTablero2.add(getBtn62());
			panelTablero2.add(getBtn72());
			panelTablero2.add(getBtn82());
		}
		return panelTablero2;
	}

	private JButton getBtn02() {
		if (btn02 == null) {
			btn02 = new JButton("");
			btn02.setActionCommand("0-2");
			btn02.setBackground(amarillo);
		}
		return btn02;
	}

	private JButton getBtn12() {
		if (btn12 == null) {
			btn12 = new JButton("");
			btn12.setVisible(false);
			btn12.setRolloverEnabled(false);
			btn12.setRequestFocusEnabled(false);
			btn12.setOpaque(false);
			btn12.setEnabled(false);
			btn12.setActionCommand("1-2");
		}
		return btn12;
	}

	private JButton getBtn22() {
		if (btn22 == null) {
			btn22 = new JButton("");
			btn22.setVisible(false);
			btn22.setEnabled(false);
			btn22.setActionCommand("2-2");
		}
		return btn22;
	}

	private JButton getBtn32() {
		if (btn32 == null) {
			btn32 = new JButton("");
			btn32.setVisible(false);
			btn32.setEnabled(false);
			btn32.setActionCommand("3-2");
		}
		return btn32;
	}

	private JButton getBtn42() {
		if (btn42 == null) {
			btn42 = new JButton("");
			btn42.setActionCommand("4-2");
			btn42.setBackground(azul);
		}
		return btn42;
	}

	private JButton getBtn52() {
		if (btn52 == null) {
			btn52 = new JButton("");
			btn52.setVisible(false);
			btn52.setEnabled(false);
			btn52.setActionCommand("5-2");
		}
		return btn52;
	}

	private JButton getBtn62() {
		if (btn62 == null) {
			btn62 = new JButton("");
			btn62.setVisible(false);
			btn62.setEnabled(false);
			btn62.setActionCommand("6-2");
		}
		return btn62;
	}

	private JButton getBtn72() {
		if (btn72 == null) {
			btn72 = new JButton("");
			btn72.setVisible(false);
			btn72.setEnabled(false);
			btn72.setActionCommand("7-2");
		}
		return btn72;
	}

	private JButton getBtn82() {
		if (btn82 == null) {
			btn82 = new JButton("");
			btn82.setActionCommand("8-2");
			btn82.setBackground(naranja);
		}
		return btn82;
	}

	private JPanel getPanelTablero3() {
		if (panelTablero3 == null) {
			panelTablero3 = new JPanel();
			panelTablero3.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero3.add(getBtn03());
			panelTablero3.add(getBtn13());
			panelTablero3.add(getBtn23());
			panelTablero3.add(getBtn33());
			panelTablero3.add(getBtn43());
			panelTablero3.add(getBtn53());
			panelTablero3.add(getBtn63());
			panelTablero3.add(getBtn73());
			panelTablero3.add(getBtn83());
		}
		return panelTablero3;
	}

	private JButton getBtn03() {
		if (btn03 == null) {
			btn03 = new JButton("");
			btn03.setActionCommand("0-3");
			btn03.setBackground(naranja);
		}
		return btn03;
	}

	private JButton getBtn13() {
		if (btn13 == null) {
			btn13 = new JButton("");
			btn13.setVisible(false);
			btn13.setEnabled(false);
			btn13.setActionCommand("1-3");
		}
		return btn13;
	}

	private JButton getBtn23() {
		if (btn23 == null) {
			btn23 = new JButton("");
			btn23.setVisible(false);
			btn23.setEnabled(false);
			btn23.setActionCommand("2-3");
		}
		return btn23;
	}

	private JButton getBtn33() {
		if (btn33 == null) {
			btn33 = new JButton("");
			btn33.setVisible(false);
			btn33.setEnabled(false);
			btn33.setActionCommand("3-3");
		}
		return btn33;
	}

	private JButton getBtn43() {
		if (btn43 == null) {
			btn43 = new JButton("");
			btn43.setActionCommand("4-3");
			btn43.setBackground(verde);
		}
		return btn43;
	}

	private JButton getBtn53() {
		if (btn53 == null) {
			btn53 = new JButton("");
			btn53.setVisible(false);
			btn53.setEnabled(false);
			btn53.setActionCommand("5-3");
		}
		return btn53;
	}

	private JButton getBtn63() {
		if (btn63 == null) {
			btn63 = new JButton("");
			btn63.setVisible(false);
			btn63.setEnabled(false);
			btn63.setActionCommand("6-3");
		}
		return btn63;
	}

	private JButton getBtn73() {
		if (btn73 == null) {
			btn73 = new JButton("");
			btn73.setVisible(false);
			btn73.setEnabled(false);
			btn73.setActionCommand("7-3");
		}
		return btn73;
	}

	private JButton getBtn83() {
		if (btn83 == null) {
			btn83 = new JButton("");
			btn83.setActionCommand("8-3");
			btn83.setBackground(amarillo);
		}
		return btn83;
	}

	private JPanel getPanelTablero4() {
		if (panelTablero4 == null) {
			panelTablero4 = new JPanel();
			panelTablero4.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero4.add(getBtn04());
			panelTablero4.add(getBtn14());
			panelTablero4.add(getBtn24());
			panelTablero4.add(getBtn34());
			panelTablero4.add(getBtn44());
			panelTablero4.add(getBtn54());
			panelTablero4.add(getBtn64());
			panelTablero4.add(getBtn74());
			panelTablero4.add(getBtn84());
		}
		return panelTablero4;
	}

	private JButton getBtn04() {
		if (btn04 == null) {
			btn04 = new JButton("");
			btn04.setOpaque(false);
			btn04.setFocusPainted(false);
			btn04.setToolTipText("Quesito de Espect\u00E1culos");

			redimensionarImagenes(btn04, "/rosa.png",
					65, 55);

			btn04.setActionCommand("0-4");
		}
		return btn04;
	}

	private JButton getBtn14() {
		if (btn14 == null) {
			btn14 = new JButton("");
			btn14.setActionCommand("1-4");
			btn14.setBackground(verde);
		}
		return btn14;
	}

	private JButton getBtn24() {
		if (btn24 == null) {
			btn24 = new JButton("");
			btn24.setActionCommand("2-4");
			btn24.setBackground(azul);
		}
		return btn24;
	}

	private JButton getBtn34() {
		if (btn34 == null) {
			btn34 = new JButton("");
			btn34.setActionCommand("3-4");
			btn34.setBackground(amarillo);
		}
		return btn34;
	}

	private JButton getBtn44() {
		if (btn44 == null) {
			btn44 = new JButton("");
			btn44.setToolTipText("Ronda final");

			redimensionarImagenes(btn44, "/casillacentral.png", 65,
					55);

			btn44.setActionCommand("4-4");
		}
		return btn44;
	}

	private JButton getBtn54() {
		if (btn54 == null) {
			btn54 = new JButton("");
			btn54.setActionCommand("5-4");
			btn54.setBackground(marron);
		}
		return btn54;
	}

	private JButton getBtn64() {
		if (btn64 == null) {
			btn64 = new JButton("");
			btn64.setActionCommand("6-4");
			btn64.setBackground(naranja);
		}
		return btn64;
	}

	private JButton getBtn74() {
		if (btn74 == null) {
			btn74 = new JButton("");
			btn74.setActionCommand("7-4");
			btn74.setBackground(rosa);
		}
		return btn74;
	}

	private JButton getBtn84() {
		if (btn84 == null) {
			btn84 = new JButton("");
			btn84.setOpaque(false);
			btn84.setFocusPainted(false);
			btn84.setToolTipText("Quesito de Ciencias y Naturaleza");

			redimensionarImagenes(btn84, "/verde.png",
					65, 55);

			btn84.setActionCommand("8-4");
		}
		return btn84;
	}

	private JPanel getPanelTablero5() {
		if (panelTablero5 == null) {
			panelTablero5 = new JPanel();
			panelTablero5.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero5.add(getBtn05());
			panelTablero5.add(getBtn15());
			panelTablero5.add(getBtn25());
			panelTablero5.add(getBtn35());
			panelTablero5.add(getBtn45());
			panelTablero5.add(getBtn55());
			panelTablero5.add(getBtn65());
			panelTablero5.add(getBtn75());
			panelTablero5.add(getBtn85());
		}
		return panelTablero5;
	}

	private JButton getBtn05() {
		if (btn05 == null) {
			btn05 = new JButton("");
			btn05.setActionCommand("0-5");
			btn05.setBackground(marron);
		}
		return btn05;
	}

	private JButton getBtn15() {
		if (btn15 == null) {
			btn15 = new JButton("");
			btn15.setVisible(false);
			btn15.setEnabled(false);
			btn15.setActionCommand("1-5");
		}
		return btn15;
	}

	private JButton getBtn25() {
		if (btn25 == null) {
			btn25 = new JButton("");
			btn25.setVisible(false);
			btn25.setEnabled(false);
			btn25.setActionCommand("2-5");
		}
		return btn25;
	}

	private JButton getBtn35() {
		if (btn35 == null) {
			btn35 = new JButton("");
			btn35.setVisible(false);
			btn35.setEnabled(false);
			btn35.setActionCommand("3-5");
		}
		return btn35;
	}

	private JButton getBtn45() {
		if (btn45 == null) {
			btn45 = new JButton("");
			btn45.setActionCommand("4-5");
			btn45.setBackground(rosa);
		}
		return btn45;
	}

	private JButton getBtn55() {
		if (btn55 == null) {
			btn55 = new JButton("");
			btn55.setVisible(false);
			btn55.setEnabled(false);
			btn55.setActionCommand("5-5");
		}
		return btn55;
	}

	private JButton getBtn65() {
		if (btn65 == null) {
			btn65 = new JButton("");
			btn65.setVisible(false);
			btn65.setEnabled(false);
			btn65.setActionCommand("6-5");
		}
		return btn65;
	}

	private JButton getBtn75() {
		if (btn75 == null) {
			btn75 = new JButton("");
			btn75.setVisible(false);
			btn75.setEnabled(false);
			btn75.setActionCommand("7-5");
		}
		return btn75;
	}

	private JButton getBtn85() {
		if (btn85 == null) {
			btn85 = new JButton("");
			btn85.setActionCommand("8-5");
			btn85.setBackground(azul);
		}
		return btn85;
	}

	private JPanel getPanelTablero6() {
		if (panelTablero6 == null) {
			panelTablero6 = new JPanel();
			panelTablero6.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero6.add(getBtn06());
			panelTablero6.add(getBtn16());
			panelTablero6.add(getBtn26());
			panelTablero6.add(getBtn36());
			panelTablero6.add(getBtn46());
			panelTablero6.add(getBtn56());
			panelTablero6.add(getBtn66());
			panelTablero6.add(getBtn76());
			panelTablero6.add(getBtn86());
		}
		return panelTablero6;
	}

	private JButton getBtn06() {
		if (btn06 == null) {
			btn06 = new JButton("");
			btn06.setActionCommand("0-6");
			btn06.setBackground(azul);
		}
		return btn06;
	}

	private JButton getBtn16() {
		if (btn16 == null) {
			btn16 = new JButton("");
			btn16.setVisible(false);
			btn16.setEnabled(false);
			btn16.setActionCommand("1-6");
		}
		return btn16;
	}

	private JButton getBtn26() {
		if (btn26 == null) {
			btn26 = new JButton("");
			btn26.setVisible(false);
			btn26.setEnabled(false);
			btn26.setActionCommand("2-6");
		}
		return btn26;
	}

	private JButton getBtn36() {
		if (btn36 == null) {
			btn36 = new JButton("");
			btn36.setVisible(false);
			btn36.setEnabled(false);
			btn36.setActionCommand("3-6");
		}
		return btn36;
	}

	private JButton getBtn46() {
		if (btn46 == null) {
			btn46 = new JButton("");
			btn46.setActionCommand("4-6");
			btn46.setBackground(naranja);
		}
		return btn46;
	}

	private JButton getBtn56() {
		if (btn56 == null) {
			btn56 = new JButton("");
			btn56.setVisible(false);
			btn56.setEnabled(false);
			btn56.setActionCommand("5-6");
		}
		return btn56;
	}

	private JButton getBtn66() {
		if (btn66 == null) {
			btn66 = new JButton("");
			btn66.setVisible(false);
			btn66.setEnabled(false);
			btn66.setActionCommand("6-6");
		}
		return btn66;
	}

	private JButton getBtn76() {
		if (btn76 == null) {
			btn76 = new JButton("");
			btn76.setVisible(false);
			btn76.setEnabled(false);
			btn76.setActionCommand("7-6");
		}
		return btn76;
	}

	private JButton getBtn86() {
		if (btn86 == null) {
			btn86 = new JButton("");
			btn86.setActionCommand("8-6");
			btn86.setBackground(marron);
		}
		return btn86;
	}

	private JPanel getPanelTablero7() {
		if (panelTablero7 == null) {
			panelTablero7 = new JPanel();
			panelTablero7.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero7.add(getBtn07());
			panelTablero7.add(getBtn17());
			panelTablero7.add(getBtn27());
			panelTablero7.add(getBtn37());
			panelTablero7.add(getBtn47());
			panelTablero7.add(getBtn57());
			panelTablero7.add(getBtn67());
			panelTablero7.add(getBtn77());
			panelTablero7.add(getBtn87());
		}
		return panelTablero7;
	}

	private JButton getBtn07() {
		if (btn07 == null) {
			btn07 = new JButton("");
			btn07.setActionCommand("0-7");
			btn07.setBackground(verde);
		}
		return btn07;
	}

	private JButton getBtn17() {
		if (btn17 == null) {
			btn17 = new JButton("");
			btn17.setVisible(false);
			btn17.setEnabled(false);
			btn17.setActionCommand("1-7");
		}
		return btn17;
	}

	private JButton getBtn27() {
		if (btn27 == null) {
			btn27 = new JButton("");
			btn27.setVisible(false);
			btn27.setEnabled(false);
			btn27.setActionCommand("2-7");
		}
		return btn27;
	}

	private JButton getBtn37() {
		if (btn37 == null) {
			btn37 = new JButton("");
			btn37.setVisible(false);
			btn37.setEnabled(false);
			btn37.setActionCommand("3-7");
		}
		return btn37;
	}

	private JButton getBtn47() {
		if (btn47 == null) {
			btn47 = new JButton("");
			btn47.setActionCommand("4-7");
			btn47.setBackground(amarillo);
		}
		return btn47;
	}

	private JButton getBtn57() {
		if (btn57 == null) {
			btn57 = new JButton("");
			btn57.setVisible(false);
			btn57.setEnabled(false);
			btn57.setActionCommand("5-7");
		}
		return btn57;
	}

	private JButton getBtn67() {
		if (btn67 == null) {
			btn67 = new JButton("");
			btn67.setVisible(false);
			btn67.setEnabled(false);
			btn67.setActionCommand("6-7");
		}
		return btn67;
	}

	private JButton getBtn77() {
		if (btn77 == null) {
			btn77 = new JButton("");
			btn77.setVisible(false);
			btn77.setEnabled(false);
			btn77.setActionCommand("7-7");
		}
		return btn77;
	}

	private JButton getBtn87() {
		if (btn87 == null) {
			btn87 = new JButton("");
			btn87.setActionCommand("8-7");
			btn87.setBackground(rosa);
		}
		return btn87;
	}

	private JPanel getPanelTablero8() {
		if (panelTablero8 == null) {
			panelTablero8 = new JPanel();
			panelTablero8.setLayout(new GridLayout(9, 1, 0, 0));
			panelTablero8.add(getBtn08());
			panelTablero8.add(getBtn18());
			panelTablero8.add(getBtn28());
			panelTablero8.add(getBtn38());
			panelTablero8.add(getBtn48());
			panelTablero8.add(getBtn58());
			panelTablero8.add(getBtn68());
			panelTablero8.add(getBtn78());
			panelTablero8.add(getBtn88());
		}
		return panelTablero8;
	}

	private JButton getBtn08() {
		if (btn08 == null) {
			btn08 = new JButton("");
			btn08.setOpaque(false);
			btn08.setFocusPainted(false);
			btn08.setToolTipText("Quesito de Historia");

			redimensionarImagenes(btn08,
					"/amarillo.png", 65, 55);

			btn08.setActionCommand("0-8");
		}
		return btn08;
	}

	private JButton getBtn18() {
		if (btn18 == null) {
			btn18 = new JButton("");
			btn18.setActionCommand("1-8");
			btn18.setBackground(naranja);
		}
		return btn18;
	}

	private JButton getBtn28() {
		if (btn28 == null) {
			btn28 = new JButton("");
			btn28.setActionCommand("2-8");
			btn28.setBackground(azul);
		}
		return btn28;
	}

	private JButton getBtn38() {
		if (btn38 == null) {
			btn38 = new JButton("");
			btn38.setActionCommand("3-8");
			btn38.setBackground(rosa);
		}
		return btn38;
	}

	private JButton getBtn48() {
		if (btn48 == null) {
			btn48 = new JButton("");
			btn48.setToolTipText("Vuelva a tirar");
			
			String url = "/dado2.png";
			redimensionarImagenes(btn48, url , 75,65);
			
			
			
//			redimensionarImagenes(JButton boton, String url, int w, int h) {
			
//			btn48.setIcon(new ImageIcon(VentanaPrincipal9x9.class.getResource("/imagenes/dados/dado2.png")));
			btn48.setActionCommand("4-8");
			btn48.setBackground(Color.white);
		}
		return btn48;
	}

	private JButton getBtn58() {
		if (btn58 == null) {
			btn58 = new JButton("");
			btn58.setActionCommand("5-8");
			btn58.setBackground(verde);
		}
		return btn58;
	}

	private JButton getBtn68() {
		if (btn68 == null) {
			btn68 = new JButton("");
			btn68.setActionCommand("6-8");
			btn68.setBackground(marron);
		}
		return btn68;
	}

	private JButton getBtn78() {
		if (btn78 == null) {
			btn78 = new JButton("");
			btn78.setActionCommand("7-8");
			btn78.setBackground(amarillo);
		}
		return btn78;
	}

	private JButton getBtn88() {
		if (btn88 == null) {
			btn88 = new JButton("");
			btn88.setOpaque(false);
			btn88.setFocusPainted(false);
			btn88.setToolTipText("Quesito de Deportes");

			redimensionarImagenes(btn88,
					"/naranja.png", 65, 55);

			btn88.setActionCommand("8-8");
		}
		return btn88;
	}

	private JPanel getPanelBtn1Arriba() {
		if (panelBtn1Arriba == null) {
			panelBtn1Arriba = new JPanel();
			panelBtn1Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn1Arriba.add(getBtnA1());
			panelBtn1Arriba.add(getBtnR1());
			panelBtn1Arriba.add(getBtnAm1());
		}
		return panelBtn1Arriba;
	}

	private JPanel getPanelBtn1Abajo() {
		if (panelBtn1Abajo == null) {
			panelBtn1Abajo = new JPanel();
			panelBtn1Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn1Abajo.add(getBtnM1());
			panelBtn1Abajo.add(getBtnV1());
			panelBtn1Abajo.add(getBtnN1());
		}
		return panelBtn1Abajo;
	}

	private JButton getBtnA1() {
		if (btnA1 == null) {
			btnA1 = new JButton("A");
			btnA1.setToolTipText("Geograf\u00EDa");
			btnA1.setEnabled(false);
		}
		return btnA1;
	}

	private JButton getBtnR1() {
		if (btnR1 == null) {
			btnR1 = new JButton("R");
			btnR1.setToolTipText("Espect\u00E1culos");
			btnR1.setEnabled(false);
		}
		return btnR1;
	}

	private JButton getBtnAm1() {
		if (btnAm1 == null) {
			btnAm1 = new JButton("Am");
			btnAm1.setToolTipText("Historia");
			btnAm1.setEnabled(false);
		}
		return btnAm1;
	}

	private JButton getBtnM1() {
		if (btnM1 == null) {
			btnM1 = new JButton("M");
			btnM1.setToolTipText("Arte y Literatura");
			btnM1.setEnabled(false);
		}
		return btnM1;
	}

	private JButton getBtnV1() {
		if (btnV1 == null) {
			btnV1 = new JButton("V");
			btnV1.setToolTipText("Ciencias y Naturaleza");
			btnV1.setEnabled(false);
		}
		return btnV1;
	}

	private JButton getBtnN1() {
		if (btnN1 == null) {
			btnN1 = new JButton("N");
			btnN1.setToolTipText("Deportes");
			btnN1.setEnabled(false);
		}
		return btnN1;
	}

	private JPanel getPanelBtn2Arriba() {
		if (panelBtn2Arriba == null) {
			panelBtn2Arriba = new JPanel();
			panelBtn2Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn2Arriba.add(getBtnA2());
			panelBtn2Arriba.add(getBtnR2());
			panelBtn2Arriba.add(getBtnAm2());
		}
		return panelBtn2Arriba;
	}

	private JButton getBtnA2() {
		if (btnA2 == null) {
			btnA2 = new JButton("A");
			btnA2.setToolTipText("Geograf\u00EDa");
			btnA2.setEnabled(false);
		}
		return btnA2;
	}

	private JButton getBtnR2() {
		if (btnR2 == null) {
			btnR2 = new JButton("R");
			btnR2.setToolTipText("Espect\u00E1culos");
			btnR2.setEnabled(false);
		}
		return btnR2;
	}

	private JButton getBtnAm2() {
		if (btnAm2 == null) {
			btnAm2 = new JButton("Am");
			btnAm2.setToolTipText("Historia");
			btnAm2.setEnabled(false);
		}
		return btnAm2;
	}

	private JPanel getPanelBtn2Abajo() {
		if (panelBtn2Abajo == null) {
			panelBtn2Abajo = new JPanel();
			panelBtn2Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn2Abajo.add(getBtnM2());
			panelBtn2Abajo.add(getBtnV2());
			panelBtn2Abajo.add(getBtnN2());
		}
		return panelBtn2Abajo;
	}

	private JButton getBtnM2() {
		if (btnM2 == null) {
			btnM2 = new JButton("M");
			btnM2.setToolTipText("Arte y Literatura");
			btnM2.setEnabled(false);
		}
		return btnM2;
	}

	private JButton getBtnV2() {
		if (btnV2 == null) {
			btnV2 = new JButton("V");
			btnV2.setToolTipText("Ciencias y Naturaleza");
			btnV2.setEnabled(false);
		}
		return btnV2;
	}

	private JButton getBtnN2() {
		if (btnN2 == null) {
			btnN2 = new JButton("N");
			btnN2.setToolTipText("Deportes");
			btnN2.setEnabled(false);
		}
		return btnN2;
	}

	private JPanel getPanelBtn3Arriba() {
		if (panelBtn3Arriba == null) {
			panelBtn3Arriba = new JPanel();
			panelBtn3Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn3Arriba.add(getBtnA3());
			panelBtn3Arriba.add(getBtnR3());
			panelBtn3Arriba.add(getBtnAm3());
		}
		return panelBtn3Arriba;
	}

	private JButton getBtnA3() {
		if (btnA3 == null) {
			btnA3 = new JButton("A");
			btnA3.setToolTipText("Geograf\u00EDa");
			btnA3.setEnabled(false);
		}
		return btnA3;
	}

	private JButton getBtnR3() {
		if (btnR3 == null) {
			btnR3 = new JButton("R");
			btnR3.setToolTipText("Espect\u00E1culos");
			btnR3.setEnabled(false);
		}
		return btnR3;
	}

	private JButton getBtnAm3() {
		if (btnAm3 == null) {
			btnAm3 = new JButton("Am");
			btnAm3.setToolTipText("Historia");
			btnAm3.setEnabled(false);
		}
		return btnAm3;
	}

	private JPanel getPanelBtn3Abajo() {
		if (panelBtn3Abajo == null) {
			panelBtn3Abajo = new JPanel();
			panelBtn3Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn3Abajo.add(getBtnM3());
			panelBtn3Abajo.add(getBtnV3());
			panelBtn3Abajo.add(getBtnN3());
		}
		return panelBtn3Abajo;
	}

	private JButton getBtnM3() {
		if (btnM3 == null) {
			btnM3 = new JButton("M");
			btnM3.setToolTipText("Arte y Literatura");
			btnM3.setEnabled(false);
		}
		return btnM3;
	}

	private JButton getBtnV3() {
		if (btnV3 == null) {
			btnV3 = new JButton("V");
			btnV3.setToolTipText("Ciencias y Naturaleza");
			btnV3.setEnabled(false);
		}
		return btnV3;
	}

	private JButton getBtnN3() {
		if (btnN3 == null) {
			btnN3 = new JButton("N");
			btnN3.setToolTipText("Deportes");
			btnN3.setEnabled(false);
		}
		return btnN3;
	}

	private JPanel getPanelBtn4Arriba() {
		if (panelBtn4Arriba == null) {
			panelBtn4Arriba = new JPanel();
			panelBtn4Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn4Arriba.add(getBtnA4());
			panelBtn4Arriba.add(getBtnR4());
			panelBtn4Arriba.add(getBtnAm4());
		}
		return panelBtn4Arriba;
	}

	private JButton getBtnA4() {
		if (btnA4 == null) {
			btnA4 = new JButton("A");
			btnA4.setToolTipText("Geograf\u00EDa");
			btnA4.setEnabled(false);
		}
		return btnA4;
	}

	private JButton getBtnR4() {
		if (btnR4 == null) {
			btnR4 = new JButton("R");
			btnR4.setToolTipText("Espect\u00E1culos");
			btnR4.setEnabled(false);
		}
		return btnR4;
	}

	private JButton getBtnAm4() {
		if (btnAm4 == null) {
			btnAm4 = new JButton("Am");
			btnAm4.setToolTipText("Historia");
			btnAm4.setEnabled(false);
		}
		return btnAm4;
	}

	private JPanel getPanelBtn4Abajo() {
		if (panelBtn4Abajo == null) {
			panelBtn4Abajo = new JPanel();
			panelBtn4Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn4Abajo.add(getBtnM4());
			panelBtn4Abajo.add(getBtnV4());
			panelBtn4Abajo.add(getBtnN4());
		}
		return panelBtn4Abajo;
	}

	private JButton getBtnM4() {
		if (btnM4 == null) {
			btnM4 = new JButton("M");
			btnM4.setToolTipText("Arte y Literatura");
			btnM4.setEnabled(false);
		}
		return btnM4;
	}

	private JButton getBtnV4() {
		if (btnV4 == null) {
			btnV4 = new JButton("V");
			btnV4.setToolTipText("Ciencias y Naturaleza");
			btnV4.setEnabled(false);
		}
		return btnV4;
	}

	private JButton getBtnN4() {
		if (btnN4 == null) {
			btnN4 = new JButton("N");
			btnN4.setToolTipText("Deportes");
			btnN4.setEnabled(false);
		}
		return btnN4;
	}

	private JPanel getPanelBtn5Arriba() {
		if (panelBtn5Arriba == null) {
			panelBtn5Arriba = new JPanel();
			panelBtn5Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn5Arriba.add(getBtnA5());
			panelBtn5Arriba.add(getBtnR5());
			panelBtn5Arriba.add(getBtnAm5());
		}
		return panelBtn5Arriba;
	}

	private JButton getBtnA5() {
		if (btnA5 == null) {
			btnA5 = new JButton("A");
			btnA5.setToolTipText("Geograf\u00EDa");
			btnA5.setEnabled(false);
		}
		return btnA5;
	}

	private JButton getBtnR5() {
		if (btnR5 == null) {
			btnR5 = new JButton("R");
			btnR5.setToolTipText("Espect\u00E1culos");
			btnR5.setEnabled(false);
		}
		return btnR5;
	}

	private JButton getBtnAm5() {
		if (btnAm5 == null) {
			btnAm5 = new JButton("Am");
			btnAm5.setToolTipText("Historia");
			btnAm5.setEnabled(false);
		}
		return btnAm5;
	}

	private JPanel getPanelBtn5Abajo() {
		if (panelBtn5Abajo == null) {
			panelBtn5Abajo = new JPanel();
			panelBtn5Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn5Abajo.add(getBtnM5());
			panelBtn5Abajo.add(getBtnV5());
			panelBtn5Abajo.add(getBtnN5());
		}
		return panelBtn5Abajo;
	}

	private JButton getBtnM5() {
		if (btnM5 == null) {
			btnM5 = new JButton("M");
			btnM5.setToolTipText("Arte y Literatura");
			btnM5.setEnabled(false);
		}
		return btnM5;
	}

	private JButton getBtnV5() {
		if (btnV5 == null) {
			btnV5 = new JButton("V");
			btnV5.setToolTipText("Ciencias y Naturaleza");
			btnV5.setEnabled(false);
		}
		return btnV5;
	}

	private JButton getBtnN5() {
		if (btnN5 == null) {
			btnN5 = new JButton("N");
			btnN5.setToolTipText("Deportes");
			btnN5.setEnabled(false);
		}
		return btnN5;
	}

	private JPanel getPanelBtn6Arriba() {
		if (panelBtn6Arriba == null) {
			panelBtn6Arriba = new JPanel();
			panelBtn6Arriba.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn6Arriba.add(getBtnA6());
			panelBtn6Arriba.add(getBtnR6());
			panelBtn6Arriba.add(getBtnAm6());
		}
		return panelBtn6Arriba;
	}

	private JButton getBtnA6() {
		if (btnA6 == null) {
			btnA6 = new JButton("A");
			btnA6.setToolTipText("Geograf\u00EDa");
			btnA6.setEnabled(false);
		}
		return btnA6;
	}

	private JButton getBtnR6() {
		if (btnR6 == null) {
			btnR6 = new JButton("R");
			btnR6.setToolTipText("Espect\u00E1culos");
			btnR6.setEnabled(false);
		}
		return btnR6;
	}

	private JButton getBtnAm6() {
		if (btnAm6 == null) {
			btnAm6 = new JButton("Am");
			btnAm6.setToolTipText("Historia");
			btnAm6.setEnabled(false);
		}
		return btnAm6;
	}

	private JPanel getPanelBtn6Abajo() {
		if (panelBtn6Abajo == null) {
			panelBtn6Abajo = new JPanel();
			panelBtn6Abajo.setLayout(new GridLayout(1, 3, 0, 0));
			panelBtn6Abajo.add(getBtnM6());
			panelBtn6Abajo.add(getBtnV6());
			panelBtn6Abajo.add(getBtnN6());
		}
		return panelBtn6Abajo;
	}

	private JButton getBtnM6() {
		if (btnM6 == null) {
			btnM6 = new JButton("M");
			btnM6.setToolTipText("Arte y Literatura");
			btnM6.setEnabled(false);
		}
		return btnM6;
	}

	private JButton getBtnV6() {
		if (btnV6 == null) {
			btnV6 = new JButton("V");
			btnV6.setToolTipText("Ciencias y Naturaleza");
			btnV6.setEnabled(false);
		}
		return btnV6;
	}

	private JButton getBtnN6() {
		if (btnN6 == null) {
			btnN6 = new JButton("N");
			btnN6.setToolTipText("Deportes");
			btnN6.setEnabled(false);
		}
		return btnN6;
	}
	
	private JPanel getPanelDado() {
		if (panelDado == null) {
			panelDado = new JPanel();
			panelDado.setLayout(new GridLayout(1, 2, 0, 0));
			panelDado.add(getBtnDado());
			panelDado.add(getLblDado());
		}
		return panelDado;
	}
	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton("");
			btnDado.setToolTipText("Pulsa para tirar el dado");
			btnDado.setFocusPainted(false);
			btnDado.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					generarNumeroDado();
				}
			});
			btnDado.setContentAreaFilled(false);
			btnDado.setOpaque(false);
			btnDado.setBorderPainted(false);
			btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/dado2.png")));
		}
		return btnDado;
	}
	private JLabel getLblDado() {
		if (lblDado == null) {
			lblDado = new JLabel("");
			lblDado.setFont(new Font("Sylfaen", Font.PLAIN, 50));
		}
		return lblDado;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void asociarEventosATodosLosBotones() {
		asociarEventosBotones(panelTablero0);
		asociarEventosBotones(panelTablero1);
		asociarEventosBotones(panelTablero2);
		asociarEventosBotones(panelTablero3);
		asociarEventosBotones(panelTablero4);
		asociarEventosBotones(panelTablero5);
		asociarEventosBotones(panelTablero6);
		asociarEventosBotones(panelTablero7);
		asociarEventosBotones(panelTablero8);

	}

	// asociamos eventos a todos los botones (incluidos los que no se ven, luego
	// no se usan para nada)
	private void asociarEventosBotones(JPanel panel) {
		for (int i = 0; i < panel.getComponents().length; i++) {
			JButton boton = (JButton) panel.getComponents()[i];
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton bt = (JButton) e.getSource();
					String[] coordenadas = bt.getActionCommand().split("-");
					// jugar o el m�todo que se vaya a usar para intentar
					// moverte a x y posicion
					if(dado != -1){
						if(Integer.parseInt(coordenadas[0]) == 4 && Integer.parseInt(coordenadas[1]) == 0 ||
								Integer.parseInt(coordenadas[0]) == 4 && Integer.parseInt(coordenadas[1]) == 8 ){
							//TODO POSIBLES CAMINOS AQUI!!!
							guardarPosicion(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1]));
							inicilizarBotonesText();
							pintarJugadorActual();
							mostrarCaminos();
						}
						else{
							inicilizarBotonesText();
							jugar(Integer.parseInt(coordenadas[0]),	Integer.parseInt(coordenadas[1]));
							mostrarTablero();
						}
					}
				}

			});
		}
	}
	
	private void inicilizarBotonesText() {
		for(int i =0; i< tabla.length; i++){
			for(int j=0; j<tabla.length; j++){
				tabla[i][j].setText("");
			}
		}
	}
	
	private void asociasTodosLosBotonesALaTabla(){
		asociarBotonesALaTabla(panelTablero0);
		asociarBotonesALaTabla(panelTablero1);
		asociarBotonesALaTabla(panelTablero2);
		asociarBotonesALaTabla(panelTablero3);
		asociarBotonesALaTabla(panelTablero4);
		asociarBotonesALaTabla(panelTablero5);
		asociarBotonesALaTabla(panelTablero6);
		asociarBotonesALaTabla(panelTablero7);
		asociarBotonesALaTabla(panelTablero8);
		
//		mostrar();
	}
	
	private void asociarBotonesALaTabla(JPanel panel){
		for (int i = 0; i < panel.getComponents().length; i++) {
			JButton boton = (JButton) panel.getComponents()[i];
			String[] coordenadas = boton.getActionCommand().split("-");
			tabla[Integer.parseInt(coordenadas[0])][Integer.parseInt(coordenadas[1])] = boton;
		}
	}
	
	private void asociarQuesitosATodosLosJugadores() {
		asociarQuesitosAJugadores(quesitosjugador1, panelBtn1Arriba,
				panelBtn1Abajo);
		asociarQuesitosAJugadores(quesitosjugador2, panelBtn2Arriba,
				panelBtn2Abajo);
		asociarQuesitosAJugadores(quesitosjugador3, panelBtn3Arriba,
				panelBtn3Abajo);
		asociarQuesitosAJugadores(quesitosjugador4, panelBtn4Arriba,
				panelBtn4Abajo);
		asociarQuesitosAJugadores(quesitosjugador5, panelBtn5Arriba,
				panelBtn5Abajo);
		asociarQuesitosAJugadores(quesitosjugador6, panelBtn6Arriba,
				panelBtn6Abajo);
	}
	
	private void mapaDeQuesitos(){
		
		mapaQuesitos.put("0", quesitosjugador1);
		mapaQuesitos.put("1", quesitosjugador2);
		mapaQuesitos.put("2", quesitosjugador3);
		mapaQuesitos.put("3", quesitosjugador4);
		mapaQuesitos.put("4", quesitosjugador5);
		mapaQuesitos.put("5", quesitosjugador6);
	}

	// asociamos los quesitos que tiene cada jugador a su array de quesitos
	private void asociarQuesitosAJugadores(JButton[] quesitosjugador12,
			JPanel panelBtn1Arriba2, JPanel panelBtn1Abajo2) {
		int i = 0;
		// panel de la izquierda
		for (i = 0; i < panelBtn1Arriba2.getComponents().length; i++) {
			quesitosjugador12[i] = (JButton) panelBtn1Arriba2.getComponents()[i];
		}
		// panel de la derecha
		for (int j = 0; j < panelBtn1Abajo2.getComponents().length; j++) {
			quesitosjugador12[i] = (JButton) panelBtn1Abajo2.getComponents()[j];
			i++;
		}
	}

	private void generarNumeroDado() {
		//deshabilitamos el dado, solo puedo pulsarlo una vez	
		btnDado.setEnabled(false);
		
		//le quitamos el marcado del movimiento anterior
		User actual = trivial.getUsuarios().get(trivial.getTurno());
		tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setText("");
		
		int aux = Dado.lanzar(); // generamos el n�mero aleatorio
		String string = "/dado" + aux + ".png"; // guardamos la imagen														// del dado
		btnDado.setIcon(new ImageIcon(VentanaPrincipal.class.getResource(string))); // se la asociamos al boton de arriba

		//cambia las imagenes del dado en los botones del tablero para que sean iguales
		redimensionarImagenes(btn40, string , 75,65);
		redimensionarImagenes(btn48, string , 75,65);
		
		dado = aux; // se la asociamos al atributo dado
		lblDado.setText("" + dado);

		mostrarCaminos();
		
		
	}

	private void mostrarCaminos() {
		//cogemos el usuario que tiene el turno
				User actual = trivial.getUsuarios().get(trivial.getTurno());
				//dependiendo del numero generado se iluminan una serie de celdas.
				trivial.mostrarTodosLosPosiblesCaminos(actual, dado);
//				trivial.calcularCaminos(actual.getCelda().getFila(),actual.getCelda().getColumna(),trivial.boleans, 0, dado);
				marcarCaminosPosibles(trivial.getMapa(), actual);
	}

	private void marcarCaminosPosibles(List<String> mapa, User actual) {
		enabledYOpaqueTabla();
		
		for(int k = 0; k<mapa.size(); k++){
			String[] coordenadas = mapa.get(k).split("-");
			tabla[Integer.parseInt(coordenadas[0])][Integer.parseInt(coordenadas[1])].setEnabled(true);
			tabla[Integer.parseInt(coordenadas[0])][Integer.parseInt(coordenadas[1])].setOpaque(true);
			
			tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setText((trivial.getTurno()+ 1) + "");
			tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setOpaque(true);
		}
	}
	
	private void enabledYOpaqueTabla() {
		for(int i = 0; i<tabla.length; i++){
			for(int j = 0; j<tabla.length; j++){
				tabla[i][j].setEnabled(false);
				tabla[i][j].setOpaque(false);
			}
		}
	}

	private void mostrarTablero(){
		for(int i = 0; i<tabla.length; i++){
			for(int j = 0; j<tabla.length; j++){
				tabla[i][j].setEnabled(true);
				tabla[i][j].setOpaque(true);
			}
		}
	}
	
	private void redimensionarImagenes(JButton boton, String url, int w, int h) {
		Image img = new ImageIcon(VentanaPrincipal.class.getResource(url)).getImage(); // cogemos la imagen
		Image newimg = (img).getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH); // la redimensionamos

		boton.setIcon(new ImageIcon(newimg)); // la asociamos al boton
	}

	private void mostrarJugadores(int numero) {
		int i = 0;

		// SE EMPIEZA A RELLENAR DE IZQUIERDA A DERECHA Y DE ARRIBA ABAJO
		// panel de la izquierda
		for (i = 0; i < panelJugadores1.getComponents().length; i++) {
			if (i < numero){
				panelJugadores1.getComponents()[i].setVisible(true);
			}
			
			panelJugador1.getComponents()[1].setEnabled(false);
		}

		// panel de la derecha
		for (int j = 0; j < panelJugadores2.getComponents().length; j++) {
			if (i < numero){
				panelJugadores2.getComponents()[j].setVisible(true);
			}
			i++;
		}
	}
	
	private void jugar(int i, int j) {
		guardarPosicion(i,j);
		crearPregunta(i,j);
		
		
		cambiarLabelsDeTurno();
		dado = -1;
		btnDado.setEnabled(true);
		inicilizarBotonesText();
		pintarJugadorActual();
		//se muestra el text en la anterior
	}
	
	public void guardarPosicion(int i,int j){
		User actual = trivial.getUsuarios().get(trivial.getTurno());
		actual.setCelda(trivial.getTablero9x9().getCeldaTablero(i,j));
	}

	private void pintarJugadorActual() {
		User actual = trivial.getUsuarios().get(trivial.getTurno());
		
		if(turnoVentana != trivial.getTurno()){
			turnoVentana = trivial.getTurno();

		}
		
		tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setText((trivial.getTurno()+ 1) + "");
		tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setFont(new Font("Sylfaen", Font.PLAIN, 50));
		tabla[actual.getCelda().getFila()][actual.getCelda().getColumna()].setOpaque(true);
	}

	private void crearPregunta(int i, int j) {
		DialogPregunta dP = new DialogPregunta(this);
		dP.setLocationRelativeTo(this);
		dP.sacarPregunta(i, j);
		dP.setVisible(true);
	}

	public void cambiarLabelsDeTurno() {
		
		int turno = trivial.getTurno();
		switch(turno){
			case 0:
				if(getJugadores()==2){
					lblJugador2.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				}
				if(getJugadores()==3){
					lblJugador3.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				}
				if(getJugadores()==4){
					lblJugador4.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				}
				if(getJugadores()==5){
					lblJugador5.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				}
				if(getJugadores()==6){
					lblJugador6.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				}
				lblJugador1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
			case 1:
				lblJugador1.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				lblJugador2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
			case 2:
				lblJugador2.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				lblJugador3.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
			case 3:
				lblJugador3.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				lblJugador4.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
			case 4:
				lblJugador4.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				lblJugador5.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
			case 5:
				lblJugador5.setFont(new Font("Sylfaen", Font.PLAIN, 11));
				lblJugador6.setFont(new Font("Sylfaen", Font.PLAIN, 17));
				break;
		}
	}
	

	private void labelsJugadores() {
		switch(getJugadores()){
		case 1:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			break;
		case 2:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			lblJugador2.setText(trivial.getUsuarios().get(1).getName());
			break;
		case 3:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			lblJugador2.setText(trivial.getUsuarios().get(1).getName());
			lblJugador3.setText(trivial.getUsuarios().get(2).getName());
			break;
		case 4:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			lblJugador2.setText(trivial.getUsuarios().get(1).getName());
			lblJugador3.setText(trivial.getUsuarios().get(2).getName());
			lblJugador4.setText(trivial.getUsuarios().get(3).getName());
			break;
		case 5:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			lblJugador2.setText(trivial.getUsuarios().get(1).getName());
			lblJugador3.setText(trivial.getUsuarios().get(2).getName());
			lblJugador4.setText(trivial.getUsuarios().get(3).getName());
			lblJugador5.setText(trivial.getUsuarios().get(4).getName());
			break;
		case 6:
			lblJugador1.setText(trivial.getUsuarios().get(0).getName());
			lblJugador2.setText(trivial.getUsuarios().get(1).getName());
			lblJugador3.setText(trivial.getUsuarios().get(2).getName());
			lblJugador4.setText(trivial.getUsuarios().get(3).getName());
			lblJugador5.setText(trivial.getUsuarios().get(4).getName());
			lblJugador6.setText(trivial.getUsuarios().get(5).getName());
			break;
		
		}
	}
	
	private void colocarJugadoresEnCentral() {
		for(int i=0; i<trivial.getUsuarios().size(); i++){
			trivial.getUsuarios().get(i).setCelda(trivial.getTablero9x9().getCeldaTablero(4, 4));
		}
	}
	
	public Trivial getPartida() {
		return trivial;
	}

	public void setPartida(Trivial trivial) {
		this.trivial = trivial;
	}
	
	public int getJugadores(){
		return numeroJugadores;
	}
	
	public void setJugadores(int jugadores){
		this.numeroJugadores = jugadores;
	}

	public void inicializarJugadores() {
		colocarJugadoresEnCentral();
		mostrarJugadores(getJugadores());
		labelsJugadores();
		
		asociarEventosATodosLosBotones();
		asociasTodosLosBotonesALaTabla();
		asociarQuesitosATodosLosJugadores();
		mapaDeQuesitos();
	}
	
	public void conseguirQuesito(){
		int actual = trivial.getTurno();
		JButton[] quesitos = mapaQuesitos.get(actual + "");
		
		/*
		 * Geografia", "Entretenimiento",
			"Historia", "Literatura", "Ciencia", "Deportes
		 */
		JButton button = new JButton();
		switch(trivial.getUsuarios().get(actual).getCelda().getCategoria()){
		case "Geografia":
			button = quesitos[0];
			redimensionarImagenes(button, "/azul.png", 40, 30);
			break;
		case "Entretenimiento":
			button = quesitos[1];
			redimensionarImagenes(button, "/rosa.png", 40, 30);
			break;
		case "Historia":
			button = quesitos[2];
			redimensionarImagenes(button, "/amarillo.png", 40, 30);
			break;
		case "Literatura":
			button = quesitos[3];
			redimensionarImagenes(button, "/marron.png", 40, 30);
			break;
		case "Ciencia":
			button = quesitos[4];
			redimensionarImagenes(button, "/verde.png", 40, 30);
			break;
		case "Deportes":
			button = quesitos[5];
			redimensionarImagenes(button, "/naranja.png", 40, 30);
			break;
		}
		//TODO QUITARLE EL FONDO A LOS QUESITOS
		button.setText("");
		button.setEnabled(true);
	}

	public void comprobarQueSeaQuesito() {
		Celda celdaActual = trivial.getUsuarios().get(trivial.getTurno()).getCelda();
		if(trivial.getTablero9x9().getCeldaTablero(celdaActual.getFila(), celdaActual.getColumna()).getQuesito()){
			conseguirQuesito();
		}
	}
}