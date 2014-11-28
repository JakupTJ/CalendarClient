package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public ActionController(Screen screen) {
		this.screen = screen;
		this.cc = new ClientController();
		
	}
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		
		if (cmd.equals(Login.LOGINSUBMIT)) {
			String email = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();
			System.out.println(email + password);
			String recieve = cc.checkLog (email, password);
			
			if (recieve.equals("Login Successful")) {
//				cc.getForecast();
				screen.show(Screen.CALENDARWEEK);
			}
		}
		
		else if (cmd.equals(CalendarWeek.BACK)) {
				screen.getCalendarWeek().refreshDates(-1);
			}
		else if (cmd.equals(CalendarWeek.NEXT)) {
				screen.getCalendarWeek().refreshDates(+1);
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

				cc.getEvents();
				System.out.println(cc.getEvents());
				
				
				
				
			}
			
				
//			 if (cmd.equals(CalendarDay.BACK)) {
//				System.out.println("hej");
//				screen.show(Screen.CALENDARWEEK);
//			}
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


