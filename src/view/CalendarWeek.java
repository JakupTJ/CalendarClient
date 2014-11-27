package view;

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
	private JTextField selectTxt;
	
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
				
				Insertdates(START_WEEK,START_YEAR);
				
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
				selectTxt = new JTextField(" ");
				activePanel.add(selectTxt);
				
				add(activePanel, BorderLayout.SOUTH);
			}

	private void Insertdates(int week, int year) {
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.YEAR, year);
		
		int thisMonth, thisDay;
		
		for (int i = 0; i < dateBtn.length; i++ ){			
			thisMonth = cal.get(Calendar.MONTH);
			thisDay = cal.get(Calendar.DAY_OF_MONTH);
			
			switch (thisMonth) {
			case 0:
				dateBtn[i] = new JButton("Jan" + " " + (thisDay));
				break;
			case 1:
				dateBtn[i] = new JButton("Feb" + " " + (thisDay));
				break;
			case 2:
				dateBtn[i] = new JButton("Mar" + " " + (thisDay));
				break;
			case 3:
				dateBtn[i] = new JButton("Apr" + " " + (thisDay));
				break;
			case 4:
				dateBtn[i] = new JButton("May" + " " + (thisDay));
				break;
			case 5:
				dateBtn[i] = new JButton("Jun" + " " + (thisDay));
				break;
			case 6:
				dateBtn[i] = new JButton("Jul" + " " + (thisDay));
				break;
			case 7:
				dateBtn[i] = new JButton("Aug" + " " + (thisDay));
				break;
			case 8:
				dateBtn[i] = new JButton("Sep" + " " + (thisDay));
				break;
			case 9:
				dateBtn[i] = new JButton("Oct" + " " + (thisDay));
				break;
			case 10:
				dateBtn[i] = new JButton("Nov" + " " + (thisDay));
				break;
			case 11:
				dateBtn[i] = new JButton("Dec" + " " + (thisDay));
				break;
			}
			Insets ins = new Insets(0, 0, 25, 25);
			dateBtn[i].setMargin(ins);
			dateBtn[i].addActionListener(actionController);
			dateBtn[i].setActionCommand(DAY);
		}
	}	
}
