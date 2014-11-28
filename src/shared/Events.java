package shared;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Events implements Serializable {

	private final long String = 3L;	
	public int id;
	public int eventid;
	public int calendarId;
	public int createdby;
	public String description;
	public String title;
	public String location;
	public Timestamp ts;
	public ArrayList<String> start;
	public ArrayList<String> end;
	public Timestamp startTimestamp;
	public Timestamp endTimestamp;
	public String type;
	public boolean active;
	public String overallID;

	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public int getCalendarId() {
		return calendarId;
	}
	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}
	public int getCreatedby() {
		return createdby;
	}
	public void setCreatedby(int createdby) {
		this.createdby = createdby;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Timestamp getTs() {
		return ts;
	}
	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
	public ArrayList<String> getStart() {
		return start;
	}
	public void setStart(ArrayList<String> start) {
		this.start = start;
	}
	public ArrayList<String> getEnd() {
		return end;
	}
	public void setEnd(ArrayList<String> end) {
		this.end = end;
	}
	public Timestamp getStartTimestamp() {
		return startTimestamp;
	}
	public void setStartTimestamp(Timestamp startTimestamp) {
		this.startTimestamp = startTimestamp;
	}
	public Timestamp getEndTimestamp() {
		return endTimestamp;
	}
	public void setEndTimestamp(Timestamp endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getOverallID() {
		return overallID;
	}
	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}
	


}