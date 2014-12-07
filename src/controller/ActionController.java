package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Calendar;
import shared.Events;
import shared.Forecast;
import shared.Note;
import shared.User;
import view.CalendarDay;
import view.CalendarSettings;
import view.CalendarWeek;
import view.CreateEvent;
import view.Login;
import view.Screen;

public class ActionController implements ActionListener {
	
	private Screen screen;
	private ClientController cc;
	public User currentUser;
	private Events events;
	private ArrayList<Events> eventsArray;
	private ArrayList<Calendar> calendarArray;
	private Gson gson;
	
	private int selectedDay;
	private int selectedMonth;
	private int selectedYear;

	public ActionController(Screen screen) {
		this.screen = screen;
		this.cc = new ClientController();
		this.currentUser = new User();
		this.events = new Events();
		this.eventsArray = new ArrayList<>();
		this.calendarArray = new ArrayList<>();
		this.gson = new GsonBuilder().create();
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if (cmd.equals(Login.LOGINSUBMIT)) {
			String email = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();
			
			String recieve = cc.checkLog (email, password);
			
			System.out.println(recieve);
			
			if (!recieve.equals("invalid")) {
				
				currentUser = (User) gson.fromJson(recieve, User.class);
								
//				qotd = c.getQotd();
				String qotd = "HEJ AGAGARDGAEDRGAEHARTHARTHARTHSRTHSTHDSFTHSFDH";
				screen.getCalendarWeek().getQotdLbl().setText(qotd);

				screen.show(Screen.CALENDARWEEK);
				
				String prepareEvents = cc.getEvents(currentUser.getUserid());
				Events[] event = gson.fromJson(prepareEvents, Events[].class);
				
				for(int i = 0; i < event.length; i++) {
					eventsArray.add(event[i]);
				}
				
				String prepareCalendar = cc.getCalendar(currentUser.getUserid());
				Calendar [] calendar = gson.fromJson(prepareCalendar, Calendar[].class);
				
				for(int i = 0; i < calendar.length; i++) {
					calendarArray.add(calendar[i]);
				}
			}
		}
		
		else if (cmd.equals(CalendarWeek.BACK)) {
			if(screen.getCalendarWeek().START_WEEK  <= 1) {
				screen.getCalendarWeek().START_WEEK = 52;
				screen.getCalendarWeek().START_YEAR--;
				screen.getCalendarWeek().refreshDates(0);
				}
			else {
				screen.getCalendarWeek().refreshDates(-1);
		}
		}
		else if (cmd.equals(CalendarWeek.NEXT)) {
			if(screen.getCalendarWeek().START_WEEK  >= 52) {
				screen.getCalendarWeek().START_WEEK = 1;
				screen.getCalendarWeek().START_YEAR++;
				screen.getCalendarWeek().refreshDates(0);
				
				}
			else{
				screen.getCalendarWeek().refreshDates(+1);
			}
			}
		else if (cmd.equals(CalendarWeek.GO)) {
			int year = Integer.parseInt(screen.getCalendarWeek().getYearTxt().getText());
			int weeknumber = Integer.parseInt(screen.getCalendarWeek().getWeekTxt().getText());
			if(weeknumber > 52) {
				
			}
			else{
			screen.getCalendarWeek().insertdates(weeknumber, year);
			screen.getCalendarWeek().START_YEAR = year;
			screen.getCalendarWeek().START_WEEK = weeknumber;
			}
		}
		else if (cmd.equals(CalendarWeek.CALSET)) {
//			screen.getCalSettings().removeTable();
			insertCalendars();
			screen.show(Screen.CALSETTINGS);
		}
		else if (cmd.equals(CalendarSettings.CREATECAL)) {
			String calName = JOptionPane.showInputDialog(null,
					"Set calendar name", null);
			int userID = currentUser.getUserid();
			String calReturn = cc.createCal(calName,userID);
			if(calReturn.equals("calendar added")){
				refreshCalendars();
//				insertCalendars();
				screen.show(Screen.CALSETTINGS);
			}
		}
		else if (cmd.equals(CalendarSettings.DELETECAL)) {
			int calID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What calendar do you want to delete?", null));
			int userID = currentUser.getUserid();
			String calReturn = cc.deleteCal(calID, userID);
			if(calReturn.equals("calendar deleted")) {
//				screen.getCalSettings().removeTable();
				refreshCalendars();
//				insertCalendars();
//				screen.show(Screen.CALSETTINGS);
			}
		}
			
		else if (cmd.equals(CalendarSettings.SHARECAL)) {
			int calID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What calendar do you want to share?", null));
			int userID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Add user to calendar", null));
			cc.shareCal(userID, calID);
		}
		else if(cmd.equals(CalendarSettings.CALWEEK)){
		screen.show(Screen.CALENDARWEEK);
		}

		else if (cmd.equals(CalendarDay.WEEK)) {
			screen.getCalendarDay().getNotePanel().setVisible(false);
			screen.getCalendarDay().getNoteLbl().setVisible(false);
			screen.getCalendarDay().getBtnSet().setVisible(false);
			screen.getCalendarDay().getSetTxtField().setVisible(false);
			screen.getCalendarDay().getNoteLbl().setText("");
				screen.show(Screen.CALENDARWEEK);
			}
		else if (cmd.equals(CalendarDay.EVENTSETTING)) {
			screen.show(Screen.CREATEEVENT);
		}
		else if (cmd.equals(CalendarDay.NOTE)) {
			int eventID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What event do you need notes for?", null));
			int i = 0;
			try{
			i = eventID; 

			String n = cc.getNote(eventID);
			Note note = gson.fromJson(n, Note.class);
			screen.getCalendarDay().getNotePanel().setVisible(true);
			screen.getCalendarDay().getNoteLbl().setVisible(true);
			screen.getCalendarDay().getBtnSet().setVisible(true);
			screen.getCalendarDay().getSetTxtField().setVisible(true);
			screen.getCalendarDay().getBtnDelNote().setVisible(true);
			screen.getCalendarDay().getNoteLbl().setText(note.getText());

			}
			catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog( screen, "You must enter a number");
			}
		}
		
		else if (cmd.equals(CalendarDay.SETNOTE)) {
			String newNote = screen.getCalendarDay().getSetTxtField().getText();
			int userID = currentUser.getUserid();
			int eventID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"add to what event?", null));
			
			cc.saveNote(eventID, userID, newNote);
			String note = cc.getNote(eventID);
			Note n = gson.fromJson(note, Note.class);

			screen.getCalendarDay().getNoteLbl().setText(n.getText());
		}
		else if (cmd.equals(CalendarDay.DELNOTE)) {
			String delNote = "";
			int eventID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"From which event?", null));
			int userID = currentUser.getUserid();
			cc.saveNote(eventID, userID, delNote);
			
			String note = cc.getNote(eventID);
			Note n = gson.fromJson(note, Note.class);

			screen.getCalendarDay().getNoteLbl().setText(n.getText());
		}
		
		
		else if (cmd.equals(CreateEvent.ADDEVENT)) {
			//Start date
			Date startDate = new Date();
			startDate.setYear(selectedYear);
			startDate.setMonth(selectedMonth);
			startDate.setDate(selectedDay);
			startDate.setHours(Integer.parseInt(screen.getCreateEvent().getTxtStartHour().getText()));
			startDate.setMinutes(Integer.parseInt(screen.getCreateEvent().getTxtStartMin().getText()));
			Timestamp startTimestamp = new Timestamp(startDate.getTime());
			
			// end date
			Date endDate = new Date();
			endDate.setYear(selectedYear);
			endDate.setMonth(selectedMonth);
			endDate.setDate(selectedDay);
			endDate.setHours(Integer.parseInt(screen.getCreateEvent().getTxtEndHour().getText()));
			endDate.setMinutes(Integer.parseInt(screen.getCreateEvent().getTxtEndMin().getText()));
			Timestamp endTimestamp = new Timestamp(endDate.getTime());
			
			// general event info
			String title = screen.getCreateEvent().getTxtTitle().getText();
			String desc = screen.getCreateEvent().getTxtDescription().getText();
			String loc = screen.getCreateEvent().getTxtLocation().getText();
			
			int calID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What calendar do you want to add the event?", null));
			int userID = currentUser.getUserid();
			
			String eventadded = cc.createEvent(userID, title, desc, loc, calID, startTimestamp, endTimestamp);
			if(eventadded.equals("eventCreated")){
				refreshEvents();
			}
		}
		
		else if (cmd.equals(CreateEvent.DELEVENT)) {
			int eventID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What event do you want to delete?", null));
//			int userID = currentUser.getUserid();
			String calReturn = cc.delEvent(eventID);
			if(calReturn.equals("calendar deleted")) {
				refreshEvents();
			}
		}
		else if (cmd.equals(CreateEvent.DAYVIEW)) {
			
			screen.show(Screen.CALENDARWEEK);
		}
		
	
			
			else {
				// Date Clicked
				int iMonth, iDay, iMid;
				String sMonthDay = cmd;
				
				iMid = sMonthDay.indexOf(screen.getCalendarWeek().MONTHDAYSEPARATOR);
				String monthString = sMonthDay.substring(0, iMid);
				
				iMonth = 0;
				if (monthString.equals("Jan")) {
					iMonth = 0;
				} else if (monthString.equals("Feb")) {
					iMonth = 1;
				} else if (monthString.equals("Mar")) {
					iMonth = 2;
				} else if (monthString.equals("Apr")) {
					iMonth = 3;
				} else if (monthString.equals("May")) {
					iMonth = 4;
				} else if (monthString.equals("Jun")) {
					iMonth = 5;
				} else if (monthString.equals("Jul")) {
					iMonth = 6;
				} else if (monthString.equals("Aug")) {
					iMonth = 7;
				} else if (monthString.equals("Sep")) {
					iMonth = 8;
				} else if (monthString.equals("Oct")) {
					iMonth = 9;
				} else if (monthString.equals("Nov")) {
					iMonth = 10;
				} else if (monthString.equals("Dec")) {
					iMonth = 11;
				}

				iDay = Integer.parseInt(sMonthDay.substring(iMid + 1,sMonthDay.length()));

				selectedDay = iDay;
				selectedMonth = iMonth;
				
				
				insertEvents(iMonth,iDay);
				
				screen.getCalendarDay().getLblDayView().setText(cmd);
				
				//get forecast and insert into Day panel
				int selectedYear = screen.getCalendarWeek().START_YEAR;
				String weather = cc.getForecast(selectedMonth+1, selectedDay, selectedYear);
				
				Forecast fc = gson.fromJson(weather, Forecast.class);
				if( fc != null) {
				screen.getCalendarDay().getForecastTxt().setText(fc.toString());
				screen.show(Screen.CALENDARDAY);
				}
				else {
					screen.getCalendarDay().getForecastTxt().setText("Forecast not available");
					screen.show(Screen.CALENDARDAY);

				}
				
			}
		
		}
	private void insertEvents(int iMonth, int iDay) {
		
		// Check to see how many columns we need to generate
		int emptyRow = 0;
		
		for(int i = 0; i < eventsArray.size(); i++) {
			
			if(eventsArray.get(i).getStartTimestamp().getMonth() == iMonth && eventsArray.get(i).getStartTimestamp().getDate() == iDay) {
				emptyRow++;
			}
		}
		
		String[] header = {"Start", "End", "Cal ID", "Event ID", "Title", "Description", "Location"};
		
		// Creating the 2D object
		Object[][] data = new Object[emptyRow][7];
		int Eventrow = 0;
		
		// adding event details to every generated column
		for(int i = 0; i < eventsArray.size(); i++) {
			
			if(eventsArray.get(i).getStartTimestamp().getMonth() == iMonth && eventsArray.get(i).getStartTimestamp().getDate() == iDay) {
				
				String start = eventsArray.get(i).getStartTimestamp().getHours() + ":" + eventsArray.get(i).getStartTimestamp().getMinutes();
				String end = eventsArray.get(i).getEndTimestamp().getHours() + ":" + eventsArray.get(i).getEndTimestamp().getMinutes();
								
				data[Eventrow][0] = start;
				data[Eventrow][1] = end;
				data[Eventrow][2] = eventsArray.get(i).getCalendarId();
				data[Eventrow][3] = eventsArray.get(i).getId();
				data[Eventrow][4] = eventsArray.get(i).getTitle();
				data[Eventrow][5] = eventsArray.get(i).getDescription();
				data[Eventrow][6] = eventsArray.get(i).getLocation();
				Eventrow++;
			}
		}
		
		screen.getCalendarDay().refreshEvents(data, header);
	}
	private void insertCalendars() {
		
		String [] header = {"Cal ID", "Title", "Created by"};
		
		Object [][] data = new Object[calendarArray.size()][3];		
		
		int calendarRow = 0;
		
		for(int i = 0; i < calendarArray.size(); i++) {
			data[calendarRow][0] = calendarArray.get(i).getCalendarid();
			data[calendarRow][1] = calendarArray.get(i).getTitle();
			data[calendarRow][2] = calendarArray.get(i).getUserid();
			
			calendarRow++;
		}
		
		screen.getCalSettings().refreshEvents(data, header);
	}
	public void refreshEvents() {
		String prepareEvents = cc.getEvents(currentUser.getUserid());
		Events[] event = gson.fromJson(prepareEvents, Events[].class);
		
		for(int i = 0; i < event.length; i++) {
			eventsArray.add(event[i]);
		}
	}
	public void refreshCalendars() {
		
		String prepareCalendar = cc.getCalendar(currentUser.getUserid());
		Calendar [] calendar = gson.fromJson(prepareCalendar, Calendar[].class);
		
		for(int i = 0; i < calendar.length; i++) {
			calendarArray.add(calendar[i]);
		}
	}
	
}


