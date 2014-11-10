package view;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ActionController;

public class Screen extends JFrame {

	public static final int WITDH = 400;
	public static final int HEIGHT = 400;

	public static final String CALENDARDAY = "calendarDay";
	public static final String CALENDARWEEK = "calendarWeek";

	private ActionController actionController;
	private JPanel contentPane;
	private CardLayout cl;
//	private Calendar calendar;
	private CalendarDay calendarDay;
	private CalendarWeek calendarWeek;
	

	// no-argument constructor
	public Screen() {
		actionController = new ActionController(this);
		setSize(WITDH,HEIGHT);

		// adding the contentPane
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) getContentPane().getLayout();

		// Objects of JPanels

		calendarWeek = new CalendarWeek();
		calendarDay = new CalendarDay();
		
		// adding JPanels

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

}
