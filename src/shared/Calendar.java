package shared;

import java.io.Serializable;

public class Calendar implements Serializable{
	private final long serialversionUID = 7L;
	private String overallID;
	private int calendarid;
	private String title;
	private int userid;
	private boolean permanent;
	private boolean active;

	public String getOverallID() {
		return overallID;
	}

	public void setOverallID(String overallID) {
		this.overallID = overallID;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getCalendarid() {
		return calendarid;
	}

	public void setCalendarid(int calendarid) {
		this.calendarid = calendarid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
