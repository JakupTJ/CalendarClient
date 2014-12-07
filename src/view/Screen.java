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
	public static final String CALSETTINGS = "calSettings";
	public static final String CREATEEVENT = "createEvent";


	

	private ActionController actionController;
	private JPanel contentPane;
	private CardLayout cl;
	private Login login;
	private CalendarDay calendarDay;
	private CalendarWeek calendarWeek;
	private CalendarSettings calSettings;
	private CreateEvent createEvent;
	

	// no-argument constructor
	public Screen() {
		actionController = new ActionController(this);
		setSize(WITDH,HEIGHT);
//		setResizable(false);

		// adding the contentPane
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) getContentPane().getLayout();

		// Objects of JPanels
		login = new Login(actionController);
		calendarWeek = new CalendarWeek(actionController);
		calendarDay = new CalendarDay(actionController);
		calSettings = new CalendarSettings(actionController);
		createEvent = new CreateEvent(actionController);
		
		// adding JPanels
		contentPane.add(login, LOGIN);
		contentPane.add(calendarWeek, CALENDARWEEK);
		contentPane.add(calendarDay, CALENDARDAY);
		contentPane.add(calSettings, CALSETTINGS);
		contentPane.add(createEvent, CREATEEVENT);

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

	public CalendarSettings getCalSettings() {
		return calSettings;
	}

	public CreateEvent getCreateEvent() {
		return createEvent;
	}

}
