package shared;

import java.io.Serializable;
import java.sql.Timestamp;

public class SimpleCall implements Serializable {

	private final long serialVersionUID = 4L;
	private String overallID;
	private int id;
	private int eventid;
	private int userId;
	private int calendarId;
	private Timestamp date;
	private int year;
	private int month;
	private int day;

	public SimpleCall() {

	}

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(int calendarId) {
		this.calendarId = calendarId;
	}

	public long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

}
