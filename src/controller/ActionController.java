package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import shared.Events;
import shared.Forecast;
import shared.Note;
import shared.User;
import view.CalendarDay;
import view.CalendarWeek;
import view.Login;
import view.Screen;

public class ActionController implements ActionListener {
	
	private Screen screen;
	private ClientController cc;
	public User currentUser;
	private Events events;
	private ArrayList<Events> eventsArray;
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
				
				
				System.out.println(currentUser.getEmail());
				
				
//				String qotd = cc.getQotd();
//				
//				screen.getCalendarWeek().getQotdLbl().setText(qotd);

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
		else if (cmd.equals(CalendarWeek.GO)) {
			int weeknumber = Integer.parseInt(screen.getCalendarWeek().getWeekTxt().getText());
			screen.getCalendarWeek().goWeek(weeknumber);
		}
		else if (cmd.equals(CalendarDay.WEEK)) {
			screen.getCalendarDay().getNotePanel().setVisible(false);
			screen.getCalendarDay().getNoteLbl().setVisible(false);
			screen.getCalendarDay().getBtnSet().setVisible(false);
			screen.getCalendarDay().getSetTxtField().setVisible(false);
			screen.getCalendarDay().getNoteLbl().setText("");
				screen.show(Screen.CALENDARWEEK);
			}
		else if (cmd.equals(CalendarDay.NOTE)) {
			int eventID = Integer.parseInt(JOptionPane.showInputDialog(null,
					"What event do need notes for?", null));
			String n = cc.getNote(eventID);
			Note note = gson.fromJson(n, Note.class);
			screen.getCalendarDay().getNotePanel().setVisible(true);
			screen.getCalendarDay().getNoteLbl().setVisible(true);
			screen.getCalendarDay().getBtnSet().setVisible(true);
			screen.getCalendarDay().getSetTxtField().setVisible(true);
			screen.getCalendarDay().getNoteLbl().setText(note.getText());

			
			}
		else if (cmd.equals(CalendarDay.SET)) {
			String newNote = screen.getCalendarDay().getSetTxtField().getText();
			screen.getCalendarDay().getNoteLbl().setText(newNote);
			cc.saveNote(newNote);
			
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
				int selectedYear = screen.getCalendarWeek().getSTART_YEAR();
				String weather = cc.getForecast(selectedMonth+1, selectedDay, selectedYear);
				
				Forecast fc = gson.fromJson(weather, Forecast.class);
				screen.getCalendarDay().getForecastTxt().setText(fc.toString());
				
				// get notes and insert into day panel

				
				screen.show(Screen.CALENDARDAY);
				
				
				
				
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


