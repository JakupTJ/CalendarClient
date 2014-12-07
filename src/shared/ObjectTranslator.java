package shared;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ServerConnection sc = new ServerConnection();
	User currentUser = new User();
	Events event = new Events();
	SimpleCall simple = new SimpleCall();
	Note note = new Note();
	Calendar cal = new Calendar();
	Gson gson = new GsonBuilder().create();

	public ObjectTranslator() {

	}

	public String checkLog(String email, String password) {
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		String gsonString = gson.toJson(currentUser);
		sc.send(gsonString);
		return sc.recieve();
	}
	
	public String getEvents(int userID) {
		simple.setOverallID("getEvents");
		simple.setUserId(userID);
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String getQotd() {
		simple.setOverallID("getQuote");
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String getForecast(int selectedMonth, int selectedDay, int selectedYear) {
		simple.setOverallID("getForecast");
		simple.setYear(selectedYear);
		simple.setMonth(selectedMonth);
		simple.setDay(selectedDay);
		
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String getNote(int eventID) {
		simple.setId(eventID);
		simple.setOverallID("getNote");
		
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	public void saveNote(String newNote) {
		note.setText(newNote);
		
		String gsonString = gson.toJson(note);
		sc.send(gsonString);		
	}

	public String delEvent(int eventID) {
		event.setId(eventID);
		event.setOverallID("deleteEvent");
		
		String gsonString = gson.toJson(event);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String createCal(String calName, int userID) {
		cal.setOverallID("createCalendar");
		cal.setUserid(userID);
		cal.setTitle(calName);
		
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
		
	}

	public String getCalendar(int userid) {
		cal.setOverallID("getCalendars");
		cal.setUserid(userid);
		
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String deleteCal(int calID, int userID) {
		cal.setOverallID("deleteCalendars");
		cal.setUserid(userID);
		cal.setCalendarid(calID);
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
	}

	public String shareCal(int userID, int calID) {
		simple.setOverallID("shareCalendar");
		simple.setUserId(userID);
		simple.setCalendarId(calID);
		
		System.out.println("I OT:"+"USER ID:"+userID+"CAL ID:"+calID);
		
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

}