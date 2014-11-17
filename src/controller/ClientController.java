package controller;

import shared.ObjectTranslator;

public class ClientController {
	
	ObjectTranslator ot = new ObjectTranslator();

	public ClientController() {
		
	}

//	public void setNote(String note) {
//		ot.setNote(note);
//	}
////
	public String checkLog(String username, String password) {
		System.out.println(username + password);
		return ot.checkLog(username, password);
	}
//
//	public String getForecast() {
//		String fc;
//		fc = ot.getForecast();
//		return fc;
//		
//	}
}
