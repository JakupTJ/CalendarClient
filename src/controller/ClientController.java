package controller;

import shared.ObjectTranslator;

public class ClientController {
	
	ObjectTranslator ot;

	public ClientController() {
		this.ot = new ObjectTranslator();

	}

//	public void setNote(String note) {
//		ot.setNote(note);
//	}
////
	public String checkLog(String username, String password) {
		String log;
		log = ot.checkLog(username, password);
		return log;
	}
//
//	public String getForecast() {
//		String fc;
//		fc = ot.getForecast();
//		return fc;
//		
//	}
}
