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

	public String getForecast(int selectedMonth, int selectedDay, int selectedYear) {
		return ot.getForecast(selectedMonth, selectedDay, selectedYear);
	}

	public String getEvents(int userID) {
		System.out.println("cc+" + userID);
		return ot.getEvents(userID);
		
	}

	public String getQotd() {
		return ot.getQotd();
	}

	public String getNote(int eventID) {
		System.out.println(eventID);
		return ot.getNote(eventID);
	}

	public void saveNote(String newNote) {
		ot.saveNote(newNote);		
	}

	public String delEvent(int eventID) {
		return ot.delEvent(eventID);		
	}

	public String createCal(String calName, int userID) {
		return ot.createCal(calName, userID);		
	}

	public String getCalendar(int userid) {
		return ot.getCalendar(userid);
	}

	public String deleteCal(int calID, int userID) {
		return ot.deleteCal(calID, userID);
	}

	public String shareCal(int calID, int userID) {
		return ot.shareCal(calID, userID);
	}
}
