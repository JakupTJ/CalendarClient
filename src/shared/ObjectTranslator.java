package shared;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ServerConnection sc = new ServerConnection();
	User user = new User();
	Events event = new Events();
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

	public Events getEvents() {
		event.setOverallID("getEvents");
		String gsonString = gson.toJson(event);
		sc.Send(gsonString);
		String received = sc.Recieve();
		Events e = (Events) gson.fromJson(received, Events.class);
		for (int i = 0; i < 10; i++) {
			System.out.println(e.getTitle());
		}
		return e;
	}

}