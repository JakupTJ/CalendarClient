package shared;

public class Events {

	public int eventid;
	public int type;
	public int location;
	public int createdby;
	public int start;
	public int end;
	public String name;
	public String text;
	public int customevent;
	public int calendarid;

	public Events(int eventid, int type, int location, int createdby,
			int start, int end, String name, String text, int customevent,
			int calendarid) {
		super();
		this.eventid = eventid;
		this.type = type;
		this.location = location;
		this.createdby = createdby;
		this.start = start;
		this.end = end;
		this.name = name;
		this.text = text;
		this.customevent = customevent;
		this.calendarid = calendarid;
	}

}
