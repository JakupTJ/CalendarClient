package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Events;
import shared.User;
import view.CalendarDay;
import view.CalendarWeek;
import view.Login;
import view.Screen;

public class ActionController implements ActionListener {
	
	private static String MONTHDAYSEPARATOR = " ";

	private Screen screen;
	private ClientController cc;
	private User currentUser;
	private Events events;
	private ArrayList<Events> eventsArray = new ArrayList<Events>();
	private Gson gson = new GsonBuilder().create();
	
	private int selectedDay;
	private int selectedMonth;

	public ActionController(Screen screen) {
		this.screen = screen;
		this.cc = new ClientController();
		this.currentUser = new User();
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		if (cmd.equals(Login.LOGINSUBMIT)) {
			String email = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();
			String recieve = cc.checkLog (email, password);
			
			if (!recieve.equals("invalid")) {
				
				currentUser = (User) gson.fromJson(recieve, User.class);

				screen.show(Screen.CALENDARWEEK);
				
				String prepareEvents = cc.getEvents(currentUser.getUserid());
				
				Events[] event = gson.fromJson(prepareEvents, Events[].class);
				
				for(int i = 0; i < event.length; i++) {
					eventsArray.add(event[i]);
				}
			}
		}
		
		else if (cmd.equals(CalendarWeek.BACK)) {
				screen.getCalendarWeek().refreshDates(-1);
			}
		else if (cmd.equals(CalendarWeek.NEXT)) {
				screen.getCalendarWeek().refreshDates(+1);
			}
		else if (cmd.equals(CalendarDay.WEEK)) {
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
				
				insertEvents(selectedDay,selectedMonth);
				
				screen.getCalendarDay().getLblDayView().setText(cmd);
				screen.show(Screen.CALENDARDAY);
				
				
				
				
			}
			
				
		
		}
	private void insertEvents(int selectedDay, int selectedMonth) {
		
		// Check to see how many columns we need to generate
		int emptyRow = 0;
		
		for(int i = 0; i < eventsArray.size(); i++) {
			
			if(eventsArray.get(i).getStartTimestamp().getMonth() == selectedMonth && eventsArray.get(i).getStartTimestamp().getDate() == selectedDay) {
				emptyRow++;
			}
		}
		
		String[] Header = {"Start", "End", "Cal ID", "Event ID", "Title", "Description", "Location"};
		
		// Creating the 2D object
		Object[][] data = new Object[emptyRow][7];
		int Eventrow = 0;
		
		// adding event details to every generated column
		for(int i = 0; i < eventsArray.size(); i++) {
			
			if(eventsArray.get(i).getStartTimestamp().getMonth() == selectedMonth && eventsArray.get(i).getStartTimestamp().getDate() == selectedDay) {
				
				String start = eventsArray.get(i).getStartTimestamp().getHours() + ":" + eventsArray.get(i).getStartTimestamp().getMinutes();
				String end = eventsArray.get(i).getEndTimestamp().getHours() + ":" + eventsArray.get(i).getEndTimestamp().getMinutes();
				
				data[Eventrow][0] = start;
				data[Eventrow][1] = end;
				data[Eventrow][2] = eventsArray.get(i).getCalendarId();
				data[Eventrow][3] = eventsArray.get(i).getEventid();
				data[Eventrow][4] = eventsArray.get(i).getTitle();
				data[Eventrow][5] = eventsArray.get(i).getDescription();
				data[Eventrow][6] = eventsArray.get(i).getLocation();
				Eventrow++;
			}
		}
		
		screen.getCalendarDay().refreshEvents(data, Header);
	}
}
		
//		else if (cmd.equals(eventView.NOTESUBMIT)){
//			String note = screen.getEventView.getTxtNote.getText();
//			String day = getDate();
//			cc.setNote(note);

		
//		else if (cmd.equals(cmd)) 
//		{
//			
//		}
//		


