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

	public void delEvent(int eventID) {
		event.setId(eventID);
		event.setOverallID("deleteEvent");
		
		String gsonString = gson.toJson(event);
		sc.send(gsonString);
	}

}