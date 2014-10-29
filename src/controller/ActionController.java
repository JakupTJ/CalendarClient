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
		
		
		
	}

}
