package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class Note implements Serializable {
	
	private final long serialversionUID = 6L;
	private int noteID;
	private int id;
	private int createdBy;
	private String text;
	private Timestamp created;
	private boolean isActive;
	private String overallID;
	
	
	public int getEventID() {
		return id;
	}


	public void setEventID(int eventID) {
		this.id = eventID;
	}


	public boolean getActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public int getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}


	public int getNoteID() {
		return noteID;
	}

	public void setNoteID(int noteID) {
		this.noteID = noteID;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
		
}
