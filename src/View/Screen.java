package View;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Screen extends JFrame {

	public static final int WITDH = 400;
	public static final int HEIGHT = 400;

	public static final String CALENDARDAY = "calendarDay";
	public static final String CALENDARWEEK = "calendarWeek";

	private CalendarDay calendarDay;
	private CalendarWeek calendarWeek;
	private JPanel contentPane;
	private CardLayout cl;

	// no-argument constructor
	public Screen() {
		setSize(WIDTH, HEIGHT);

		// adding the contentPane
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		cl = (CardLayout) getContentPane().getLayout();

		// Objects of JPanels

		calendarDay = new CalendarDay();
		calendarWeek = new CalendarWeek();

		// adding JPanels

		contentPane.add(calendarDay);
		contentPane.add(calendarWeek);

	}

	public void Show(String card) {
		cl.show(getContentPane(), card);
	}

	public CalendarDay getCalendarDay() {
		return calendarDay;
	}

	public CalendarWeek getCalendarWeek() {
		return calendarWeek;
	}

}
