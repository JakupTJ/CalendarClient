package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ClientController cc = new ClientController();
	ServerConnection sc = new ServerConnection ();
	User user = new User();

//	String obj = cc.setNote(note);

	Gson gson = new GsonBuilder().create();

//	String gsonString = gson.toJson(obj);
	
	public ObjectTranslator() {
		
	}

	public void setNote(String note) {

	
	}

	public String checkLog(String username, String password) {
		user.setUserName(username);
		user.setPassword(password);
		user.setActive(1);
		String gsonString = gson.toJson(user);
		sc.Send(gsonString);
		String received = sc.Recieve();
	return received;		
	}
//
//	public String getForecast() {
//		String fc;
////		return fc;
//	}

}