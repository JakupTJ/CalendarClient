package view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class CalendarWeek extends JPanel {

	JPanel pane;
	JPanel calendarPanel;
	JPanel timePanel;
	JLabel dateColumn;
	JLabel weekColumn;
	JLabel timeColumn;

	public CalendarWeek() {
		setSize(Screen.WITDH, Screen.HEIGHT);
		// Setting JPanel to Gridlayout
		 new JPanel(new BorderLayout());
		 setLayout(new GridLayout(0, 7));
		 Border border = BorderFactory.createLineBorder(Color.black);
		 setBorder(border);

		// Headers
		calendarPanel = new JPanel(new BorderLayout());
		calendarPanel.setLayout(new GridLayout(0, 7));
		String[] headers = { "Monday", "Tuesday", "Wednesday", "Tuesday",
				"Friday", "Saturday", "Sunday" };

		for (String header : headers) {
			add(weekColumn = new JLabel(header));
		}
		// Add days to calendar
		for (int i = 1; i < 31; i++) {
			add(dateColumn = new JLabel("" + i));
			dateColumn.setBorder(border);
		}

		// Add calendar to main panel
		pane = new JPanel(new BorderLayout());
		pane.add(new JTextField("\t\t\t04/2014"), BorderLayout.NORTH);
		pane.add(this, BorderLayout.CENTER);

		// // Panel with hours of the day
		// timePanel = new JPanel(new BorderLayout());
		// setLayout(new GridLayout(0,1));
		//
		// String[] timeStamp = {"08:00", "09:00", "10:00"};
		//
		// for (String ts : timeStamp) {
		// timePanel.add(timeColumn = new JLabel(ts));
		// }
		//
		// pane.add(timePanel,BorderLayout.WEST);

	}
}
