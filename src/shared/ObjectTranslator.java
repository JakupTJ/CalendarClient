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
	Gson gson = new GsonBuilder().create();

	public ObjectTranslator() {

	}

	public String checkLog(String email, String password) {
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		String gsonString = gson.toJson(currentUser);
		System.out.println(gsonString);
		sc.Send(gsonString);
		return sc.Recieve();
	}
	
	public String getEvents(int userID) {
		simple.setOverallID("getEvents");
		simple.setUserId(userID);
		String gsonString = gson.toJson(simple);
		sc.Send(gsonString);
		return sc.Recieve();
	}

	public String getQotd() {
		simple.setOverallID("getQuote");
		String gsonString = gson.toJson(simple);
		sc.Send(gsonString);
		return sc.Recieve();
	}

	public String getForecast(int selectedMonth, int selectedDay) {
		System.out.println(selectedMonth + " " + selectedDay);
		simple.setOverallID("getForecast");
		simple.setYear(2014);
		simple.setMonth(selectedMonth);
		simple.setDay(selectedDay);
		
		String gsonString = gson.toJson(simple);
		sc.Send(gsonString);
		return sc.Recieve();
	}

	public String getNote(int eventID) {
		simple.setId(eventID);
		simple.setOverallID("getNote");
		
		String gsonString = gson.toJson(simple);
		sc.Send(gsonString);
		return sc.Recieve();
	}

	public void saveNote(String newNote) {
		
	}

}