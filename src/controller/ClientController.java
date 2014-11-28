package controller;

import shared.ObjectTranslator;
import shared.User;

public class ClientController {

	private User currentUser;
	ObjectTranslator ot = new ObjectTranslator();

	public ClientController() {

	}

	public User checkLog(String username, String password) {
		System.out.println(username + password);
		ot.checkLog(username, password);
		return currentUser;
	}

	public String getForecast() {
		String fc;
		fc = ot.getForecast();
		return fc;

	}

	public String getEvents() {
		return ot.getEvents();
		
	}
}
