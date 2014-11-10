package controller;

public class NotesController {

	public NotesController() {

	}

	public void setNote(String note) {
		shared.ObjectTranslator.setNote(note);
	}
}
