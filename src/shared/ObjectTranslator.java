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

	public String getForecast() {
		simple.setOverallID("getForecast");
		String gsonString = gson.toJson(simple);
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

}