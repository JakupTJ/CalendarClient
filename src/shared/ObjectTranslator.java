package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {
	
	ClientController nc = new ClientController();
	
	public ObjectTranslator() {
		
	}

	String obj = nc.setNote(note);
	
	
	Gson gson = new GsonBuilder().create();
	
	String gsonString = gson.toJson(obj);

}