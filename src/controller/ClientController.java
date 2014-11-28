package controller;

import shared.Events;
import shared.ObjectTranslator;
import shared.User;

public class ClientController {

	private User currentUser;
	
	ObjectTranslator ot = new ObjectTranslator();

	public ClientController() {

	}

	public String checkLog(String email, String password) {
		System.out.println(email + password);
		return ot.checkLog(email, password);
	}

	public String getForecast() {
		String fc;
		fc = ot.getForecast();
		return fc;

	}

	public Events getEvents() {
		return ot.getEvents();
		
	}
}
