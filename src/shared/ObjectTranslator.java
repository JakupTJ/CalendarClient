package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {

	ClientController cc = new ClientController();

	String obj = cc.setNote(note);

	Gson gson = new GsonBuilder().create();

	String gsonString = gson.toJson(obj);
	
	public ObjectTranslator() {
		
	}

	public void setNote(String note) {

	}

	public String checkLog(String username, String password) {
		String log;
		return log;		
	}

	public String getForecast() {
		String fc;
		return fc;
	}

}