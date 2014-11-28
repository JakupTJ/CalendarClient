package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import shared.User;
import view.CalendarDay;
import view.CalendarWeek;
import view.Login;
import view.Screen;

public class ActionController implements ActionListener {
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
			String username = screen.getLogin().getTxtremail().getText();
			String password = screen.getLogin().getPasswordField().getText();
			System.out.println(username + password);
			currentUser = cc.checkLog (username, password);
			
			if (currentUser != null) {
				cc.getForecast();
				screen.show(Screen.CALENDARWEEK);
			}
		}
		
		else if (cmd.equals(CalendarWeek.BACK)) {
				screen.getCalendarWeek().refreshDates(-1);
			}
		else if (cmd.equals(CalendarWeek.NEXT)) {
				screen.getCalendarWeek().refreshDates(+1);
			}
		else if (cmd.equals(CalendarWeek.DAY)) {
				// Sammenlign år med år, månen måned, dag dag med den ønskede d
				
				cc.getEvents();
				System.out.println(cc.getEvents());
				screen.show(Screen.CALENDARDAY);
			}
		
			else if (cmd.equals(CalendarDay.BACK)) {
				System.out.println("hej");
				screen.show(Screen.CALENDARWEEK);
			}
		}
		
//		else if (cmd.equals(eventView.NOTESUBMIT)){
//			String note = screen.getEventView.getTxtNote.getText();
//			String day = getDate();
//			cc.setNote(note);
		}
		
//		else if (cmd.equals(cmd)) 
//		{
//			
//		}
//		


