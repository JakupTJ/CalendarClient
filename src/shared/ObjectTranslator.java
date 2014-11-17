package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ServerConnection sc = new ServerConnection();
	User user = new User();
	Gson gson = new GsonBuilder().create();

	public ObjectTranslator() {

	}

	public void setNote(String note) {

	}

	public String checkLog(String username, String password) {
		user.setUserName(username);
		user.setPassword(password);
		user.setActive(true);
		user.setOverallID("logIn");
		String gsonString = gson.toJson(user);
		System.out.println(gsonString);
		sc.Send(gsonString);
		String received = sc.Recieve();
		return received;
	}
	//
	// public String getForecast() {
	// String fc;
	// // return fc;
	// }

}