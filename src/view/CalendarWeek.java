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
	public static final String FORWARD = "forward";
	public static final String GO = "go";
	
	private static String days[] = {"MON", "TUE", "WED", "THU", "FRI", "SAT",  "SUN"};


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
		
			
		// Add dayPanel to main panel
		headerPanel = new JPanel(new GridLayout(0,7));
		headerPanel.setBackground(Color.GRAY);
		headerPanel.setVisible(true);
		add(headerPanel, BorderLayout.NORTH);
		
		for (String day : days) {
			JLabel weekColumn = new JLabel(("" + day),SwingConstants.CENTER);
			headerPanel.add(weekColumn, new GridLayout(2,7));
		}
	}
}