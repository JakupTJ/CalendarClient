package shared;

import java.sql.Timestamp;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjectTranslator {

	ServerConnection sc = new ServerConnection();
	User currentUser = new User();
	Events event = new Events();
	SimpleCall simple = new SimpleCall();
	Note note = new Note();
	Calendar cal = new Calendar();
	Gson gson = new GsonBuilder().create();

	public ObjectTranslator() {

	}
	
	/**
	 * Sends the login information from the user
	 * to the server for authentication
	 * @param email 
	 * @param password
	 * @return Response from server
	 */

	public String checkLog(String email, String password) {
		currentUser.setEmail(email);
		currentUser.setPassword(password);
		String gsonString = gson.toJson(currentUser);
		sc.send(gsonString);
		return sc.recieve();
	}
	
	/**
	 * Gets all events from server, both CBS and user generated
	 * @param userID is the current users ID
	 * @return response from server
	 */
	public String getEvents(int userID) {
		simple.setOverallID("getEvents");
		simple.setUserId(userID);
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Gets Quote of the day from the server
	 * @return response from server
	 */
	public String getQotd() {
		simple.setOverallID("getQuote");
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Gets forecast basen on the chosen day
	 * @param selectedMonth
	 * @param selectedDay
	 * @param selectedYear
	 * @return response from server
	 */
	public String getForecast(int selectedMonth, int selectedDay, int selectedYear) {
		simple.setOverallID("getForecast");
		simple.setYear(selectedYear);
		simple.setMonth(selectedMonth);
		simple.setDay(selectedDay);
		
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Get a specific note from server
	 * @param eventID is a user chosen eventID
	 * @return response from server
	 */
	public String getNote(int eventID) {
		note.setEventID(eventID);
		note.setOverallID("getNote");
		
		String gsonString = gson.toJson(note);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Sends user chosen note to server and saves it in database
	 * @param eventID is the same eventID as in getNote
	 * @param userID is current users ID
	 * @param newNote is the new user generated text
	 * @return response from server
	 */
	public String saveNote(int eventID, int userID, String newNote) {
		note.setOverallID("createNote");
		note.setCreatedBy(userID);
		note.setEventID(eventID);
		note.setText(newNote);
		
		String gsonString = gson.toJson(note);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Inserts a blank note where eventID
	 * is the same as in getNote
	 * @param eventID
	 * @return response from server
	 */
	public String delEvent(int eventID) {
		simple.setId(eventID);
		simple.setOverallID("deleteEvent");
		
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}
	
	/**
	 * Creates a new Calendar
	 * @param calName is name of the calendar
	 * @param userID is the created by
	 * @return response from server
	 */

	public String createCal(String calName, int userID) {
		cal.setOverallID("createCalendar");
		cal.setUserid(userID);
		cal.setTitle(calName);
		
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Gets all the calendars from server
	 * @param userid is sent to know if
	 * the user is subscribe to calendar or not
	 * @return response from server
	 */
	public String getCalendar(int userid) {
		cal.setOverallID("getCalendars");
		cal.setUserid(userid);
		
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Deletes calendar
	 * @param calID
	 * @param userID
	 * @return
	 */
	public String deleteCal(int calID, int userID) {
		cal.setOverallID("deleteCalendars");
		cal.setUserid(userID);
		cal.setCalendarid(calID);
		String gsonString = gson.toJson(cal);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Shares calendar with another user
	 * @param userID what user to share with
	 * @param calID what calendar to share
	 * @return response from server
	 */
	public String shareCal(int userID, int calID) {
		simple.setOverallID("shareCalendar");
		simple.setUserId(userID);
		simple.setCalendarId(calID);
				
		String gsonString = gson.toJson(simple);
		sc.send(gsonString);
		return sc.recieve();
	}

	/**
	 * Creates events with all the relevant variables
	 * @param userID
	 * @param title
	 * @param desc
	 * @param loc
	 * @param calID
	 * @param startTimestamp
	 * @param endTimestamp
	 * @return
	 */
	public String createEvent(int userID, String title, String desc, String loc, int calID, Timestamp startTimestamp, Timestamp endTimestamp) {
		event.setOverallID("createEvent");
		event.setCreatedby(userID);
		event.setTitle(title);
		event.setDescription(desc);
		event.setLocation(loc);
		event.setStartTimestamp(startTimestamp);
		event.setEndTimestamp(endTimestamp);
		event.setCalendarId(calID);
		String gsonString = gson.toJson(event);
		sc.send(gsonString);
		return sc.recieve();
	}

}