package controller;

import java.sql.Timestamp;
import shared.ObjectTranslator;

public class ClientController {
	ObjectTranslator ot;

	public ClientController() {
		ot = new ObjectTranslator();
	}

	public String checkLog(String email, String password) {
		System.out.println(email + password);
		return ot.checkLog(email, password);
	}

	public String getForecast(int selectedMonth, int selectedDay,
			int selectedYear) {
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

	public String saveNote(int eventID, int userID, String newNote) {
		return ot.saveNote(eventID, userID, newNote);
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

	public String shareCal(int userID, int calID) {
		return ot.shareCal(userID, calID);
	}

	public String createEvent(int userID, String title, String desc,
			String loc, int calID, Timestamp startTimestamp,
			Timestamp endTimestamp) {
		return ot.createEvent(userID, title, desc, loc, calID, startTimestamp,
				endTimestamp);
	}
}
