package es.uniovi.asw.game.igu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.uniovi.asw.game.persistence.UserDb;

public class DialogLogin extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4826891126713164125L;
	private final JPanel contentPanel = new JPanel();
	private JPanel pnPrincipal;
	private JPanel pnSpinner;
	private JLabel lbTituloSpinner;
	private JSpinner spJugadores;
	private JButton btnConfirmar;
	private JButton btnRegistrarse;
	private JPanel pnRegistrarse;
	private CardLayout cl = new CardLayout(0, 0);
	private int jugadores = 0;
	private int contador = 0;
	private JPanel pnLogin;
	private JPanel pnCentro;
	private JPanel pnTitulo;
	private JLabel lbTituloLogin;
	private JPanel pnUsuario;
	private JPanel pnPassword;
	private JPasswordField pfPassword;
	private JTextField txUsuario;
	private JButton btConfirmarLogin;
	UserDb usuariodb = new UserDb();
	VentanaPrincipal vp = null;
	private JPanel pnRegistro;
	private JPanel pnDatos;
	private JLabel lbUsuarioRegistro;
	private JTextField txUsuarioRegistro;
	private JLabel lbContraseniaRegistro;
	private JPasswordField pfContraseniaRegistro;
	private JLabel lbContraseniaRegistro2;
	private JPasswordField pfContraseniaRegistro2;
	private JButton btRegistrarse;
	private JPanel pnTituloRegistro;
	private JLabel lbTituloRegistro;
	private JButton btCancelar;
	private JButton btCancelarRegistro;
	private JButton btCancelarLogin;
	
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			DialogLogin dialog = new DialogLogin(null);
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//			dialog.setLocationRelativeTo(null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public DialogLogin(VentanaPrincipal vp) {

		this.vp = vp;
//		usuariodb.addUser("aninabg", "seguridad");
//		usuariodb.addUser("samolo", "secure");
		setBounds(100, 100, 581, 421);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(cl);
		contentPanel.add(getPnPrincipal(), "pnPrincipal");
		contentPanel.add(getPnLogin(), "pnLogin");
		contentPanel.add(getPnRegistro(), "pnRegistro");
		
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(vp);
		setModal(true);
		setVisible(true);
	}

	private JPanel getPnPrincipal() {
		if (pnPrincipal == null) {
			pnPrincipal = new JPanel();
			pnPrincipal.setLayout(new GridLayout(2, 1, 0, 0));
			pnPrincipal.add(getPnSpinner());
			pnPrincipal.add(getPnRegistrarse());
		}
		return pnPrincipal;
	}
	private JPanel getPnSpinner() {
		if (pnSpinner == null) {
			pnSpinner = new JPanel();
			pnSpinner.setLayout(null);
			pnSpinner.add(getLbTituloSpinner());
			pnSpinner.add(getSpJugadores());
			pnSpinner.add(getBtnConfirmar());
		}
		return pnSpinner;
	}
	private JLabel getLbTituloSpinner() {
		if (lbTituloSpinner == null) {
			lbTituloSpinner = new JLabel("Seleccione el n\u00FAmero de jugadores:");
			lbTituloSpinner.setBounds(210, 25, 170, 28);
		}
		return lbTituloSpinner;
	}
	private JSpinner getSpJugadores() {
		if (spJugadores == null) {
			spJugadores = new JSpinner();
			spJugadores.setBounds(274, 71, 43, 28);
			spJugadores.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		}
		return spJugadores;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(244, 120, 108, 31);
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jugadores = (Integer) spJugadores.getValue();
					cl.show(contentPanel, "pnLogin");
					
				}
			});
		}
		return btnConfirmar;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cl.show(contentPanel, "pnRegistro");
				}
			});
			btnRegistrarse.setBounds(117, 39, 117, 32);
		}
		return btnRegistrarse;
	}
	private JPanel getPnRegistrarse() {
		if (pnRegistrarse == null) {
			pnRegistrarse = new JPanel();
			pnRegistrarse.setLayout(null);
			pnRegistrarse.add(getBtnRegistrarse());
			pnRegistrarse.add(getBtCancelar());
		}
		return pnRegistrarse;
	}
	private JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new JPanel();
			pnLogin.setLayout(new BorderLayout(0, 0));
			pnLogin.add(getPnCentro(), BorderLayout.CENTER);
			pnLogin.add(getPnTitulo(), BorderLayout.NORTH);
		}
		return pnLogin;
	}
	private JPanel getPnCentro() {
		if (pnCentro == null) {
			pnCentro = new JPanel();
			pnCentro.setLayout(null);
			pnCentro.add(getPnPassword());
			pnCentro.add(getPnUsuario());
			pnCentro.add(getBtConfirmarLogin());
			pnCentro.add(getBtCancelarLogin());
		}
		return pnCentro;
	}
	private JPanel getPnTitulo() {
		if (pnTitulo == null) {
			pnTitulo = new JPanel();
			pnTitulo.add(getLbTituloLogin());
		}
		return pnTitulo;
	}
	private JLabel getLbTituloLogin() {
		if (lbTituloLogin == null) {
			lbTituloLogin = new JLabel("Login");
			lbTituloLogin.setFont(new Font("Stencil", Font.PLAIN, 59));
		}
		return lbTituloLogin;
	}
	private JPanel getPnUsuario() {
		if (pnUsuario == null) {
			pnUsuario = new JPanel();
			pnUsuario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Usuario 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			pnUsuario.setBounds(199, 61, 167, 91);
			pnUsuario.setLayout(null);
			pnUsuario.add(getTxUsuario());
		}
		return pnUsuario;
	}
	private JPanel getPnPassword() {
		if (pnPassword == null) {
			pnPassword = new JPanel();
			pnPassword.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Contrase\u00F1a:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnPassword.setBounds(199, 163, 167, 91);
			pnPassword.setLayout(null);
			pnPassword.add(getPfPassword());
		}
		return pnPassword;
	}
	private JPasswordField getPfPassword() {
		if (pfPassword == null) {
			pfPassword = new JPasswordField();
			pfPassword.setBounds(10, 30, 147, 32);
		}
		return pfPassword;
	}
	private JTextField getTxUsuario() {
		if (txUsuario == null) {
			txUsuario = new JTextField();
			txUsuario.setBounds(10, 31, 147, 31);
			txUsuario.setColumns(10);
		}
		return txUsuario;
	}
	private JButton getBtConfirmarLogin() {
		if (btConfirmarLogin == null) {
			btConfirmarLogin = new JButton("Confirmar");
			btConfirmarLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					//Obtenemos el usuario y la password de los campos.
					String name = txUsuario.getText();
					String password = String.valueOf(pfPassword.getPassword());
					
					//Si existe en la tabla 
					//TODO modificar por código real bbdd
					if(usuariodb.login(name, password)) {
						vp.getPartida().getUsuarios().add(usuariodb.lookup(name));
						contador++;
						System.out.println(name);
						pnUsuario.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Usuario " + (contador+1), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

						pnUsuario.revalidate();
						pnUsuario.repaint();
					}
					
					if(contador!=jugadores) {
						limpiarLogin();
						cl.show(contentPanel, "pnLogin");
					} else {
						vp.cargarJugadores();
						dispose();
					}
				
				}
			});
			btConfirmarLogin.setBounds(437, 258, 89, 23);
		}
		return btConfirmarLogin;
	}

	protected void limpiarLogin() {
		txUsuario.setText("");
		pfPassword.setText("");
		
	}
	private JPanel getPnRegistro() {
		if (pnRegistro == null) {
			pnRegistro = new JPanel();
			pnRegistro.setLayout(new BorderLayout(0, 0));
			pnRegistro.add(getPnDatos());
			pnRegistro.add(getPnTituloRegistro(), BorderLayout.NORTH);
		}
		return pnRegistro;
	}
	private JPanel getPnDatos() {
		if (pnDatos == null) {
			pnDatos = new JPanel();
			pnDatos.setLayout(null);
			pnDatos.add(getLbUsuarioRegistro());
			pnDatos.add(getTxUsuarioRegistro());
			pnDatos.add(getLbContraseniaRegistro());
			pnDatos.add(getPfContraseniaRegistro());
			pnDatos.add(getLbContraseniaRegistro2());
			pnDatos.add(getPfContraseniaRegistro2());
			pnDatos.add(getBtRegistrarse());
			pnDatos.add(getBtCancelarRegistro());
		}
		return pnDatos;
	}
	private JLabel getLbUsuarioRegistro() {
		if (lbUsuarioRegistro == null) {
			lbUsuarioRegistro = new JLabel("Usuario");
			lbUsuarioRegistro.setBounds(209, 71, 36, 14);
		}
		return lbUsuarioRegistro;
	}
	private JTextField getTxUsuarioRegistro() {
		if (txUsuarioRegistro == null) {
			txUsuarioRegistro = new JTextField();
			txUsuarioRegistro.setBounds(255, 71, 131, 20);
			txUsuarioRegistro.setColumns(10);
		}
		return txUsuarioRegistro;
	}
	private JLabel getLbContraseniaRegistro() {
		if (lbContraseniaRegistro == null) {
			lbContraseniaRegistro = new JLabel("Contrase\u00F1a:");
			lbContraseniaRegistro.setBounds(185, 121, 60, 14);
		}
		return lbContraseniaRegistro;
	}
	private JPasswordField getPfContraseniaRegistro() {
		if (pfContraseniaRegistro == null) {
			pfContraseniaRegistro = new JPasswordField();
			pfContraseniaRegistro.setBounds(255, 121, 131, 20);
		}
		return pfContraseniaRegistro;
	}
	private JLabel getLbContraseniaRegistro2() {
		if (lbContraseniaRegistro2 == null) {
			lbContraseniaRegistro2 = new JLabel("Repita su contrase\u00F1a:");
			lbContraseniaRegistro2.setBounds(139, 169, 106, 14);
		}
		return lbContraseniaRegistro2;
	}
	private JPasswordField getPfContraseniaRegistro2() {
		if (pfContraseniaRegistro2 == null) {
			pfContraseniaRegistro2 = new JPasswordField();
			pfContraseniaRegistro2.setBounds(255, 166, 131, 20);
		}
		return pfContraseniaRegistro2;
	}
	private JButton getBtRegistrarse() {
		if (btRegistrarse == null) {
			btRegistrarse = new JButton("Registrarse");
			btRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String username = txUsuarioRegistro.getText();
					String pass1 = String.valueOf(pfContraseniaRegistro.getPassword());
					String pass2 = String.valueOf(pfContraseniaRegistro2.getPassword());
					if(pass1.equals(pass2) && pass1.length()!=0) {
						usuariodb.addUser(username, pass1);
						limpiarRegistro();
						cl.show(contentPanel, "pnPrincipal");
					} else {
						System.out.println("Las contraseñas no coinciden");
					}
					
				}

			});
			btRegistrarse.setBounds(306, 220, 89, 23);
		}
		return btRegistrarse;
	}
	
	

	private void limpiarRegistro() {
		txUsuarioRegistro.setText("");
		pfContraseniaRegistro.setText("");
		pfContraseniaRegistro2.setText("");
		
	}
	
	private JPanel getPnTituloRegistro() {
		if (pnTituloRegistro == null) {
			pnTituloRegistro = new JPanel();
			pnTituloRegistro.add(getLbTituloRegistro());
		}
		return pnTituloRegistro;
	}
	private JLabel getLbTituloRegistro() {
		if (lbTituloRegistro == null) {
			lbTituloRegistro = new JLabel("Registro");
			lbTituloRegistro.setFont(new Font("Stencil", Font.PLAIN, 59));
		}
		return lbTituloRegistro;
	}
	private JButton getBtCancelar() {
		if (btCancelar == null) {
			btCancelar = new JButton("Cancelar");
			btCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			btCancelar.setBounds(326, 39, 117, 32);
		}
		return btCancelar;
	}
	private JButton getBtCancelarRegistro() {
		if (btCancelarRegistro == null) {
			btCancelarRegistro = new JButton("Cancelar");
			btCancelarRegistro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					limpiarRegistro();
					cl.show(contentPanel, "pnPrincipal");
				}
			});
			btCancelarRegistro.setBounds(169, 220, 89, 23);
		}
		return btCancelarRegistro;
	}
	private JButton getBtCancelarLogin() {
		if (btCancelarLogin == null) {
			btCancelarLogin = new JButton("Cancelar");
			btCancelarLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					limpiarLogin();
					jugadores = 0;
					contador = 0;
					vp.getPartida().getUsuarios().clear();
					cl.show(contentPanel, "pnPrincipal");
				}
			});
			btCancelarLogin.setBounds(338, 258, 89, 23);
		}
		return btCancelarLogin;
	}
}
