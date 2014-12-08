package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import controller.ActionController;
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
		label.setBounds(404, 11, 100, 20);
		add(label);

		txtremail = new JTextArea("dafr13ab@student.cbs.dk");
		txtremail.setBounds(329, 80, 250, 29);
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
				if (txtremail.getText().equals("Insert your CBS-email address"))
					txtremail.setText("");

			}
		});

		passwordField = new JPasswordField("123456");
		passwordField.setBounds(329, 122, 250, 29);
		add(passwordField);

		btnLogin = new JButton("Login to BCBS");
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(LOGINSUBMIT);
		btnLogin.setBounds(388, 176, 132, 26);
		add(btnLogin);

		btnQuitBcbs = new JButton("Quit BCBS");
		btnQuitBcbs.setBounds(405, 221, 98, 26);
		add(btnQuitBcbs);

		lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 908, 260);
		add(lblBackground);
	}

	public JTextArea getTxtremail() {
		return txtremail;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
