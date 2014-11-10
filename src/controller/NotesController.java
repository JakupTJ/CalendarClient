package controller;

public class NotesController {
	
	
	public NotesController() {
		
	}
	

	public String UpdateNote() {
		String note;
		note = shared.ObjectTranslator.GetNote();
		return note;
	}
}
