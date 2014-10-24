package View;

import javax.swing.JPanel;
import javax.swing.JButton;

public class CalendarWeek extends JPanel {

	JPanel pane;
	JPanel calendarPane;
	JPanel weeknumber;
	JButton btnNext;
	JButton btnBack;

	public CalendarWeek() {

		setLayout(null);
		setSize(Screen.WITDH, Screen.HEIGHT);

		pane = new JPanel();
		pane.setBounds(12, 12, 376, 376);
		add(pane);

		btnNext = new JButton("Next");
		btnNext.setBounds(266, 12, 98, 26);
		add(btnNext);

		weeknumber = new JPanel();
		weeknumber.setBounds(114, 12, 145, 32);
		add(weeknumber);

		btnBack = new JButton("Previous");
		btnBack.setBounds(12, 12, 98, 26);
		add(btnBack);

		calendarPane = new JPanel();
		calendarPane.setBounds(12, 56, 352, 276);
		add(calendarPane);

	}
}
