package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controller.ActionController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;

public class Login extends JPanel {

	private ActionController actionController;
	private JTextArea txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JLabel lblBackground;
	private JButton btnQuitBcbs;

	public static final String LOGINSUBMIT = "loginsubmit";

	public Login(ActionController actionController) {
		this.actionController = actionController;
		setLayout(null);
		setSize(Screen.WIDTH, Screen.HEIGHT);

		JLabel label = new JLabel("Login");
		label.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 16));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(110, 11, 100, 20);
		add(label);

		txtremail = new JTextArea("Insert your CBS-email adress");
		txtremail.setBounds(35, 125, 250, 29);
		add(txtremail);

		txtremail.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtremail.getText().equals("Insert your CBS-email adress"))
					txtremail.setText("");

			}
		});

		passwordField = new JPasswordField("**********");
		passwordField.setBounds(35, 175, 250, 29);
		add(passwordField);

		btnLogin = new JButton("Login to BCBS");
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(Screen.LOGIN);
		btnLogin.setBounds(94, 298, 132, 26);
		add(btnLogin);

		btnQuitBcbs = new JButton("Quit BCBS");
		btnQuitBcbs.setBounds(111, 387, 98, 26);
		add(btnQuitBcbs);

		lblBackground = new JLabel("");
		lblBackground
				.setIcon(new ImageIcon(
						"C:\\Users\\JákupToftum\\Desktop\\Mítt\\Ha.IT\\"
								+ "2. Semester\\TIPR\\Projekt\\myndir\\bitcoin-wall.jpg"));
		lblBackground.setBounds(0, 0, 320, 480);
		add(lblBackground);

		// Model.User u = dc.login(email, password);

	}

	public JTextArea getTxtremail() {
		return txtremail;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
