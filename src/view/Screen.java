package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ActionController;

public class Screen extends JFrame {

	public static final int WITDH = 950;
	public static final int HEIGHT = 320;

	public static final String LOGIN = "login";
	public static final String CALENDARDAY = "calendarDay";
	public static final String CALENDARWEEK = "calendarWeek";
	

	private ActionController actionController;
	private JPanel contentPane;
	private CardLayout cl;
	private Login login;
	private CalendarDay calendarDay;
	private CalendarWeek calendarWeek;
	

	// no-argument constructor
	public Screen() {
		actionController = new ActionController(this);
		setSize(WITDH,HEIGHT);
		setResizable(false);

		// adding the contentPane
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) getContentPane().getLayout();

		// Objects of JPanels

		calendarWeek = new CalendarWeek(actionController);
		login = new Login(actionController);
		calendarDay = new CalendarDay(actionController);
		
		// adding JPanels
		contentPane.add(login, LOGIN);
		contentPane.add(calendarWeek, CALENDARWEEK);
		contentPane.add(calendarDay, CALENDARDAY);

	}

	public void show(String card) {
		cl.show(getContentPane(), card);
	}

	public CalendarWeek getCalendarWeek() {
		return calendarWeek;
	}
	
	public CalendarDay getCalendarDay() {
		return calendarDay;
	}

	public Login getLogin() {
		return login;
	}

}
