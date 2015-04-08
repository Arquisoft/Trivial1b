package es.uniovi.asw.game.igu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import es.uniovi.asw.trivial.infraestructure.model.Answer;
import es.uniovi.asw.trivial.infraestructure.model.Question;


public class DialogPregunta extends JDialog {

	/**
	 * 
	 */

	
	private List<JButton> botones = new ArrayList<JButton>();
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JLabel labelQuestion;
	private VentanaPrincipal vp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DialogPregunta frame = new DialogPregunta(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DialogPregunta(VentanaPrincipal vp) {
		this.vp = vp;
		setTitle("Pregunta");
				
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getLabelQuestion(), BorderLayout.NORTH);
		contentPane.add(getPanelCentral(), BorderLayout.CENTER);
		setModal(true);
	}

	private JPanel getPanelCentral() {
		if (panelCentral == null) {
			panelCentral = new JPanel();
			panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return panelCentral;
	}

	private JLabel getLabelQuestion() {
		if (labelQuestion == null) {
			labelQuestion = new JLabel();
			labelQuestion.setHorizontalAlignment(SwingConstants.CENTER);
			labelQuestion.setPreferredSize(new Dimension(0, 50));
		}
		return labelQuestion;
	}
	
	public void sacarPregunta()  {
		Question q = vp.getPartida().sacarPregunta();
		labelQuestion.setText(q.getQuestion());
		mostrarRespuestas(q);
	}
	
	private void mostrarRespuestas(Question question)  {
		for(Answer a: question.getAnswers()) 
			crearComponentesRespuesta(a.getResponse(), a.isCorrect());
		
	}
	
	private void crearComponentesRespuesta(String respuesta, boolean isCorrect) {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JButton boton = new JButton();
		boton.setText(respuesta);
		boton.setPreferredSize(new Dimension(300, 30));
		JLabel label = new JLabel();
		
		botones.add(boton);
		
		panel.add(boton, BorderLayout.WEST);
		panel.add(label, BorderLayout.EAST);
		panelCentral.add(panel);
		
		asociarEvento(boton, isCorrect, label);
		
		
	}

	private void asociarEvento(JButton boton, final boolean isCorrect, final JLabel label) {
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarRespuesta(isCorrect, label);
			}
		});
	}
	
	private void comprobarRespuesta(boolean isCorrect, JLabel label) {
		if(isCorrect) {
//			System.out.println("Respuesta correcta");O
			label.setIcon(new ImageIcon(getClass().getResource("/tick.png")));
//			JOptionPane.showMessageDialog(null, "Respuesta Correcta");
		}
		else {
//			System.out.println("Respuesta incorrecta");
			label.setIcon(new ImageIcon(getClass().getResource("/cross.png")));
//			JOptionPane.showMessageDialog(null, "Respuesta Incorrecta");
		}
		
		desactivar();
		
	}
	
	private void desactivar() {
		for(JButton b: botones)
			b.setEnabled(false);
	}
	
	
}
