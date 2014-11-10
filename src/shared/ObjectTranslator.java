package shared;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controller.NotesController;

public class ObjectTranslator {
	
	NotesController nc = new NotesController();
	
	public ObjectTranslator() {
		
	}

	String obj = nc.setNote(note);
	
	
	Gson gson = new GsonBuilder().create();
	
	String gsonString = gson.toJson(obj);

}