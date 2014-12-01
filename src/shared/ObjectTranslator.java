package shared;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ServerConnection sc = new ServerConnection();
	User user = new User();
	Events event = new Events();
	SimpleCall simple = new SimpleCall();
	Gson gson = new GsonBuilder().create();

	public ObjectTranslator() {

	}

	public String checkLog(String email, String password) {
		user.setEmail(email);
		user.setPassword(password);
		user.setActive(true);
		user.setOverallID("logIn");
		String gsonString = gson.toJson(user);
		System.out.println(gsonString);
		sc.Send(gsonString);
		String received = sc.Recieve();
		System.out.println(received);
		return received;
	}

	public String getForecast() {
		String fc;
		fc = "getClientForecast";
		String gsonString = gson.toJson(fc);
		sc.Send(gsonString);
		String received = sc.Recieve();
		return received;
	}

	public String getEvents(int userID) {
		simple.setUserId(userID);
		String gsonString = gson.toJson(simple);
		sc.Send(gsonString);
		return sc.Recieve();
	}

}