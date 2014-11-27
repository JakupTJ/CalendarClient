package view;

import javax.management.StringValueExp;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import controller.ActionController;

import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarWeek extends JPanel {

	public static final String BACK ="back";
	public static final String NEXT = "next";
	public static final String GO = "go";
	public static final String DAY = "day";
	
	private static String days[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
	private static int START_WEEK;
	private static int START_YEAR;
	
	private JPanel headerPanel;
	private JPanel calendarPanel;
	private JPanel activePanel;
	private JButton[] dateBtn = new JButton[7];
	private JButton previousBtn;
	private JButton forwardBtn;
	private JButton goBtn;
	private JLabel weekLbl;
	private JTextField weekTxt;
	
	private Calendar cal = new GregorianCalendar();
	private ActionController actionController;
	
	public CalendarWeek(ActionController actionController) {
		this.actionController = actionController;
		setSize(Screen.WITDH, Screen.HEIGHT);
		setLayout(new BorderLayout());
		
		START_WEEK = cal.get(GregorianCalendar.WEEK_OF_YEAR);
		START_YEAR = cal.get(GregorianCalendar.YEAR);
			
		// Add dayPanel to main panel
		headerPanel = new JPanel(new GridLayout(0,7));
		headerPanel.setBackground(Color.GRAY);
		headerPanel.setVisible(true);
		add(headerPanel, BorderLayout.NORTH);
		
		for (String day : days) {
			JLabel weekColumn = new JLabel(("" + day),SwingConstants.CENTER);
			headerPanel.add(weekColumn, new GridLayout(2,7));
		}
		
		// add calendarPanel to main panel
				calendarPanel = new JPanel(new GridLayout(0,7));
				calendarPanel.setVisible(true);
				add(calendarPanel, BorderLayout.CENTER);	
				// Insert buttons as weekdays
				for ( int b = 0; b < dateBtn.length; b++) {
					dateBtn[b] = new JButton();
//					dateBtn[e].addActionListener(actionController);
//					dateBtn[e].setActionCommand("button" + e);
					calendarPanel.add(dateBtn[b], new GridLayout(2,7));
					}
				
				insertdates(START_WEEK,START_YEAR);
				
				//add activePanel to main panel
				activePanel = new JPanel(new GridLayout(1,5));
				activePanel.setVisible(true);
				
				//Buttons to activePanel
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
				activePanel.add(weekLbl);
				
				//Interactive TextField to activePanel
				weekTxt = new JTextField(" ");
				activePanel.add(weekTxt);
				
				add(activePanel, BorderLayout.SOUTH);
			}

	private void insertdates(int week, int year) {
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);
		
		int thisMonth, thisDay;
		
		for (int i = 0; i < dateBtn.length; i++ ){			
			thisMonth = cal.get(Calendar.MONTH);
			thisDay = cal.get(Calendar.DAY_OF_MONTH);
			
			switch (thisMonth) {
			case 0:
				dateBtn[i].setText("Jan" + " " + (thisDay));
				break;
			case 1:
				dateBtn[i].setText("Feb" + " " + (thisDay));
				break;
			case 2:
				dateBtn[i].setText("Mar" + " " + (thisDay));
				break;
			case 3:
				dateBtn[i].setText("Apr" + " " + (thisDay));
				break;
			case 4:
				dateBtn[i].setText("May" + " " + (thisDay));
				break;
			case 5:
				dateBtn[i].setText("Jun" + " " + (thisDay));
				break;
			case 6:
				dateBtn[i].setText("Jul" + " " + (thisDay));
				break;
			case 7:
				dateBtn[i].setText("Aug" + " " + (thisDay));
				break;
			case 8:
				dateBtn[i].setText("Sep" + " " + (thisDay));
				break;
			case 9:
				dateBtn[i].setText("Oct" + " " + (thisDay));
				break;
			case 10:
				dateBtn[i].setText("Nov" + " " + (thisDay));
				break;
			case 11:
				dateBtn[i].setText("Dec" + " " + (thisDay));
				break;
			}
			cal.add(Calendar.DATE, 1);
			Insets ins = new Insets(0, 0, 25, 25);
			dateBtn[i].setMargin(ins);
			dateBtn[i].addActionListener(actionController);
			dateBtn[i].setActionCommand(DAY);
		}
	}
	
	public void refreshDates(int nextWeek) {
		
		START_WEEK += nextWeek;
		insertdates(START_WEEK, START_YEAR);
		
		String stringWeek = String.valueOf(START_WEEK);
		
		weekTxt.setText(stringWeek);
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
}
