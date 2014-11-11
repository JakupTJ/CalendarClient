package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.ClientController;

public class ObjectTranslator {
	
	ClientController cc = new ClientController();
	
	public ObjectTranslator() {
		
	}

	String obj = cc.setNote(note);
	
	
	Gson gson = new GsonBuilder().create();
	
	String gsonString = gson.toJson(obj);

	public void setNote(String note) {	
		
	}

}