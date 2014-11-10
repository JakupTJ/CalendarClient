package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Screen;

public class ActionController implements ActionListener {
	private Screen screen;

	public ActionController(Screen screen) {
		this.screen = screen;
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals(eventView.EVENTSUBMIT)){
			String note = screen.getEventView.getTxtNote.getText();
			String day = getDate();
			NotesController.setNote(note, day);
		}
		
		else if (cmd.equals(login.LOGINSUBMIT)) {
			username = screen.getLogin.getTxtEmail.getText();
			password = screen.getLogin.getTxtpassword.getText();
			LoginController.checklog(username, password);
		}
		
	}

}
