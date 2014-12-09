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
	private JLabel topLabel;
	private JTextArea txtremail;
	private JPasswordField passwordField;
	private JButton btnLogin;
	private JButton btnQuitBcbs;

	public static final String LOGINSUBMIT = "loginsubmit";

	public Login(ActionController actionController) {
		this.actionController = actionController;
		setSize(Screen.WIDTH, Screen.HEIGHT);
		setLayout(null);


		topLabel = new JLabel("Login");
		topLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		topLabel.setHorizontalAlignment(SwingConstants.CENTER);
		topLabel.setBounds(404, 11, 44, 20);
		add(topLabel);

		txtremail = new JTextArea("Insert your CBS-email address");
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

		passwordField = new JPasswordField("");
		passwordField.setBounds(329, 122, 250, 29);
		add(passwordField);

		btnLogin = new JButton("Login to CBS Calendar");
		btnLogin.addActionListener(actionController);
		btnLogin.setActionCommand(LOGINSUBMIT);
		btnLogin.setBounds(388, 176, 159, 25);
		add(btnLogin);

		btnQuitBcbs = new JButton("Quit CBS Calendar");
		btnQuitBcbs.setBounds(405, 221, 137, 25);
		add(btnQuitBcbs);
	}

	public JTextArea getTxtremail() {
		return txtremail;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}
}
