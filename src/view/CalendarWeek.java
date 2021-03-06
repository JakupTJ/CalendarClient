package view;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import controller.ActionController;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class CalendarWeek extends JPanel {

	public static String MONTHDAYSEPARATOR = " ";
	public static final String BACK = "back";
	public static final String NEXT = "next";
	public static final String GO = "go";
	public static final String DAY = "day";
	public static final String CALSET = "calSet";
;


	private static String days[] = { "MON", "TUE", "WED", "THU", "FRI", "SAT","SUN" };
	public static int START_WEEK;
	public static int START_YEAR;
	

	private JPanel quotePanel;
	private JLabel qotdLbl;
	private JPanel headerPanel;
	private JPanel calendarPanel;
	private JPanel activePanel;
	private JButton[] dateBtn = new JButton[7];
	private JButton previousBtn;
	private JButton forwardBtn;
	private JButton goBtn;
	private JLabel weekLbl;
	private JTextField weekTxt;
	private JPanel bottomPanel;


	private Calendar cal = new GregorianCalendar();
	private ActionController actionController;
	private JLabel lblYear;
	private JTextField yearTxt;
	private JButton btnCalSettings;
	

	public CalendarWeek(ActionController actionController) {
		this.actionController = actionController;
		setSize(Screen.WITDH, Screen.HEIGHT);
		setLayout(new BorderLayout());

		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);

		// add top panel to main pain

		// Add headerPanel to top panel
		headerPanel = new JPanel(new GridLayout(0, 7));
		headerPanel.setPreferredSize(new Dimension(10, 35));
		headerPanel.setBorder(new MatteBorder(0, 20, 0, 20, (Color) null));
//		headerPanel.setBackground(Color.GRAY);
		headerPanel.setVisible(true);
		add(headerPanel, BorderLayout.NORTH);

		for (String day : days) {
			JLabel weekColumn = new JLabel(("" + day), SwingConstants.CENTER);
//			weekColumn.setBorder(new MatteBorder(0, 1, 0, 1, Color.BLACK));
			headerPanel.add(weekColumn, new GridLayout(2, 7));
		}

		// add calendarPanel to main panel
		calendarPanel = new JPanel(new GridLayout(0, 7));
		calendarPanel.setBorder(new MatteBorder(0, 20, 0, 20, (Color) null));
		calendarPanel.setVisible(true);
		add(calendarPanel, BorderLayout.CENTER);
		// Insert buttons as weekdays
		for (int b = 0; b < dateBtn.length; b++) {
			dateBtn[b] = new JButton();
			// dateBtn[e].addActionListener(actionController);
			// dateBtn[e].setActionCommand("button" + e);
			calendarPanel.add(dateBtn[b], new GridLayout(2, 7));
		}

		insertdates(START_WEEK, START_YEAR);

		bottomPanel = new JPanel();
		bottomPanel.setBorder(new MatteBorder(0, 15, 5, 15, (Color) null));
		bottomPanel.setLayout(new BorderLayout());
		add(bottomPanel, BorderLayout.SOUTH);

		
		// add activePanel to main panel
		activePanel = new JPanel(new GridLayout(1, 5));
		activePanel.setVisible(true);
		activePanel.setPreferredSize(new Dimension(0,35));
		bottomPanel.add(activePanel, BorderLayout.SOUTH);


		// Buttons to activePanel
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(actionController);
		previousBtn.setActionCommand(BACK);
		activePanel.add(previousBtn);

		forwardBtn = new JButton("Next ");
		forwardBtn.addActionListener(actionController);
		forwardBtn.setActionCommand(NEXT);
		activePanel.add(forwardBtn);

		goBtn = new JButton("Go to selected week");
		goBtn.addActionListener(actionController);
		goBtn.setActionCommand(GO);
		activePanel.add(goBtn);

		// Info labels to activePanel
		weekLbl = new JLabel("Week:");
		weekLbl.setHorizontalAlignment(SwingConstants.CENTER);
		weekLbl.setPreferredSize(new Dimension(10,10));

		activePanel.add(weekLbl);

		// Interactive TextField to activePanel
		weekTxt = new JTextField("" + START_WEEK);
		
		activePanel.add(weekTxt);
		
		lblYear = new JLabel("Year:");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setPreferredSize(new Dimension(10,10));
		activePanel.add(lblYear);
		
		yearTxt = new JTextField("" + START_YEAR);
		activePanel.add(yearTxt);

		quotePanel = new JPanel();
		quotePanel.setBorder(new MatteBorder(1, 1, 1, 1, Color.BLACK));
		bottomPanel.add(quotePanel, BorderLayout.NORTH);
		
		btnCalSettings = new JButton("Calendar settings");
		btnCalSettings.addActionListener(actionController);
		btnCalSettings.setActionCommand(CALSET);
		quotePanel.add(btnCalSettings);

		qotdLbl = new JLabel("");
		qotdLbl.setHorizontalAlignment(SwingConstants.CENTER);
//		qotdLbl.setPreferredSize(new Dimension(0,20));
		qotdLbl.setVisible(true);
		quotePanel.add(qotdLbl);
	}

	

	public void insertdates(int week, int year) {
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);

		int thisMonth, thisDay;

		for (int i = 0; i < dateBtn.length; i++) {
			thisMonth = cal.get(Calendar.MONTH);
			thisDay = cal.get(Calendar.DAY_OF_MONTH);

			switch (thisMonth) {
			case 0:
				dateBtn[i].setText("Jan" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 1:
				dateBtn[i].setText("Feb" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 2:
				dateBtn[i].setText("Mar" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 3:
				dateBtn[i].setText("Apr" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 4:
				dateBtn[i].setText("May" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 5:
				dateBtn[i].setText("Jun" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 6:
				dateBtn[i].setText("Jul" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 7:
				dateBtn[i].setText("Aug" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 8:
				dateBtn[i].setText("Sep" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 9:
				dateBtn[i].setText("Oct" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 10:
				dateBtn[i].setText("Nov" + MONTHDAYSEPARATOR + (thisDay));
				break;
			case 11:
				dateBtn[i].setText("Dec" + MONTHDAYSEPARATOR + (thisDay));
				break;
			}
			
			cal.add(Calendar.DATE, 1);
			dateBtn[i].addActionListener(actionController);
		}
	}

	public void refreshDates(int nextWeek) {

		START_WEEK += nextWeek;
	
			insertdates(START_WEEK, START_YEAR);
		
		String stringWeek = String.valueOf(START_WEEK);
		String stringYear = String.valueOf(START_YEAR);

		weekTxt.setText(stringWeek);
		yearTxt.setText(stringYear);
	}

	public JPanel getCalendarPanel() {
		return calendarPanel;
	}

	public void setCalendarPanel(JPanel calendarPanel) {
		this.calendarPanel = calendarPanel;
	}

	public JPanel getActivePanel() {
		return activePanel;
	}

	public void setActivePanel(JPanel activePanel) {
		this.activePanel = activePanel;
	}

	public JLabel getWeekLbl() {
		return weekLbl;
	}

	public void setWeekLbl(JLabel weekLbl) {
		this.weekLbl = weekLbl;
	}

	public JTextField getWeekTxt() {
		return weekTxt;
	}

	public void setWeekTxt(JTextField weekTxt) {
		this.weekTxt = weekTxt;
	}

	public JButton[] getDateBtn() {
		return dateBtn;
	}

	public void setQotdLbl(JLabel qotdLbl) {
		this.qotdLbl = qotdLbl;
	}

	public JLabel getQotdLbl() {
		return qotdLbl;
	}



	public JTextField getYearTxt() {
		return yearTxt;
	}
}
