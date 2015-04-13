package es.uniovi.asw.game.igu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.game.model.User;
import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;

import java.awt.Font;

import javax.swing.JTextArea;

import java.awt.Color;

public class DialogPregunta extends JDialog {
	
	private List<JButton> botones = new ArrayList<JButton>();

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private VentanaPrincipal vp;
	private JPanel panelNorte;
	private JLabel labelCategoria;
	private JLabel labelTitulo;
	private JTextArea textAreaQuestion;
	
	String[] categorias = new String[] { "Geografía", "Espectaculos",
			"Historia", "Arte y Literatura", "Ciencia", "Deportes"};

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DialogPregunta frame = new DialogPregunta(null);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public DialogPregunta(VentanaPrincipal vp) {
		this.vp = vp;
		setTitle("Pregunta");

		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelCentral(), BorderLayout.CENTER);
		setModal(true);
	}

	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setBackground(Color.WHITE);
			panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return panelCentral;
	}
	
	public void sacarPreguntaAleatoria(){
		int categoria = (int) ((Math.random()*6) + 1);
		Question q = vp.getPartida().sacarPregunta(categorias[categoria]);
		sacarPregunta(q);
	}
	
	public void sacarPreguntaCategoria(String categoria){
		Question q = vp.getPartida().sacarPregunta(categoria);
		sacarPregunta(q);
	}
	
	public void sacarPreguntaPorCelda(int i, int j) {
		Question q = vp.getPartida().sacarPregunta(i, j);
		sacarPregunta(q);
	}

	private void sacarPregunta(Question q) {
		q.setUsed(true);
		textAreaQuestion.setText(q.getQuestion());
		labelCategoria.setText(q.getCategoria().toUpperCase());
		labelTitulo.setText(q.getTitle().toUpperCase());
		mostrarRespuestas(q);
	}

	private void mostrarRespuestas(Question question) {
		for (Answer a : question.getAnswers())
			crearComponentesRespuesta(a.getResponse(), a.isCorrect());

	}

	private void crearComponentesRespuesta(String respuesta, boolean isCorrect) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BorderLayout());
		
		JButton boton = new JButton();
		boton.setBackground(Color.WHITE);
		boton.setText(respuesta);
		boton.setPreferredSize(new Dimension(300, 30));
		
		JLabel label = new JLabel();
		label.setOpaque(true);
		label.setBackground(Color.WHITE);

		panel.add(boton, BorderLayout.WEST);
		panel.add(label, BorderLayout.EAST);
		panelCentral.add(panel);

		botones.add(boton);

		asociarEvento(boton, isCorrect, label);

	}

	private void asociarEvento(JButton boton, final boolean isCorrect,
			final JLabel label) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarRespuesta(isCorrect, label);
				cerrarTrasXTiempo(); //no aparece el tick de respuesta correcta, comentar esto sino se soluciona
			}
		});
	}
	
	private void cerrarTrasXTiempo() {
		long t1 = System.currentTimeMillis();
		long t2 =0;
		long tiempo = 0;
		while(tiempo <5000){
			t2 = System.currentTimeMillis();
			tiempo = t2-t1;
		}
			
		if(tiempo==5000){
			this.processWindowEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}

	private void comprobarRespuesta(boolean isCorrect, JLabel label) {
		if (isCorrect) {
			// System.out.println("Respuesta correcta");
			label.setIcon(new ImageIcon(getClass().getResource("/tick.png")));
			//sigue el mismo jugador, no cambia nada			
			// JOptionPane.showMessageDialog(null, "Respuesta Correcta");
			
			//comprobamos si obtiene quesito
			vp.comprobarQueSeaQuesito();
			
			//actualizamos el contador de preguntas acertadas
			vp.setRes(vp.getRes()+1);
			User actual = vp.getPartida().getUsuarios().get(vp.getPartida().getTurno());
			actual.setnRightQuestions(actual.getnRightQuestions()+1);
		} else {
			// System.out.println("Respuesta incorrecta");
			label.setIcon(new ImageIcon(getClass().getResource("/cross.png")));
			
			//actualizamos el contador de preguntas falladas
			User actual = vp.getPartida().getUsuarios().get(vp.getPartida().getTurno());
			actual.setnWrongQuestions(actual.getnWrongQuestions()+1);
			
			//cambiamos el jugador cuando la respuesta es incorrecta
			vp.getPartida().getSiguienteJugador();
			// JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
		}

		desactivar();

	}

	private void desactivar() {
		for (JButton b : botones)
			b.setEnabled(false);
	}

	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setBackground(Color.WHITE);
			panelNorte.setPreferredSize(new Dimension(10, 100));
			panelNorte.setLayout(null);
			panelNorte.add(getLabelCategoria());
			panelNorte.add(getLabelTitulo());
			panelNorte.add(getTextAreaQuestion());
		}
		return panelNorte;
	}

	private JLabel getLabelCategoria() {
		if (labelCategoria == null) {
			labelCategoria = new JLabel();
			labelCategoria.setBackground(Color.WHITE);
			labelCategoria.setOpaque(true);
			labelCategoria.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 12));
			labelCategoria.setHorizontalAlignment(SwingConstants.CENTER);
			labelCategoria.setBounds(0, 0, 210, 40);
		}
		return labelCategoria;
	}

	private JLabel getLabelTitulo() {
		if (labelTitulo == null) {
			labelTitulo = new JLabel();
			labelTitulo.setBackground(Color.WHITE);
			labelTitulo.setOpaque(true);
			labelTitulo.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 12));
			labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
			labelTitulo.setBounds(214, 0, 210, 40);
		}
		return labelTitulo;
	}

	private JTextArea getTextAreaQuestion() {
		if (textAreaQuestion == null) {
			textAreaQuestion = new JTextArea();
			textAreaQuestion.setFont(new Font("Sylfaen", Font.PLAIN, 14));
			textAreaQuestion.setLineWrap(true);
			textAreaQuestion.setWrapStyleWord(true);
			textAreaQuestion.setEditable(false);
			textAreaQuestion.setBounds(0, 40, 424, 60);
		}
		return textAreaQuestion;
	}
}
