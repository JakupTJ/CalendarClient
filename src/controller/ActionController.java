package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Login;
import view.Screen;

public class ActionController implements ActionListener {
	private Screen screen;
	private ClientController cc;

	public ActionController(Screen screen) {
		this.screen = screen;
		this.cc = new ClientController();
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		if (cmd.equals(Login.LOGINSUBMIT)) {
			String username = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();
			System.out.println(username + password);
			cc.checkLog(username, password);
			
//			cc.getForecast();
		}
		
//		else if (cmd.equals(eventView.NOTESUBMIT)){
//			String note = screen.getEventView.getTxtNote.getText();
//			String day = getDate();
//			cc.setNote(note);
		}
		
//		else if (cmd.equals(cmd)) 
//		{
//			
//		}
//		
	}


