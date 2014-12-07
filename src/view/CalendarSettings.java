package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import controller.ActionController;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class CalendarSettings extends JPanel{

	public static final String CREATEEVE = "createeve";
	public static final String DELETEEVE = "deleteeve";
	public static final String DELNOTE = "delnote";
	public static final String CREATECAL = "createCal";
	public static final String DELETECAL = "deleteCal";
	public static final String SHARECAL = "shareCal";
	public static final String WEEK = "week";
	public static final String SETNOTE = "setNote";


	
	private ActionController actionController;
	private JLabel lblDayView;
	private JPanel eventPanel;
	private JPanel activePanel;
	private JTable calTable;
	private JScrollPane scrollPane;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnBack;
	private JButton btnCreateCalendar;
	private JButton btnDeleteCalendar;
	private JButton btnShareCalendar;
	
	public CalendarSettings (ActionController actionController) {
		this.actionController = actionController;
		setSize(Screen.WITDH,Screen.HEIGHT);
		setLayout(new BorderLayout());
		
		lblDayView = new JLabel("Calendar settings");
		lblDayView.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayView, BorderLayout.NORTH);
		
		
		eventPanel = new JPanel();
		eventPanel.setLayout(new BorderLayout(0, 0));
		add(eventPanel, BorderLayout.CENTER);
		
		activePanel = new JPanel();
		eventPanel.add(activePanel, BorderLayout.WEST);
		
		btnCreate = new JButton("Create event");
		btnCreate.addActionListener(actionController);
		
		btnCreateCalendar = new JButton("Create Calendar");
		btnCreateCalendar.addActionListener(actionController);
		activePanel.setLayout(new GridLayout(0, 1, 0, 0));
		btnCreateCalendar.setActionCommand(CREATECAL);
		activePanel.add(btnCreateCalendar);
		
		btnDeleteCalendar = new JButton("Delete Calendar");
		btnDeleteCalendar.addActionListener(actionController);
		btnDeleteCalendar.setActionCommand(DELETECAL);
		activePanel.add(btnDeleteCalendar);
		
		btnShareCalendar = new JButton("Share Calendar");
		btnShareCalendar.addActionListener(actionController);
		btnShareCalendar.setActionCommand(SHARECAL);
		activePanel.add(btnShareCalendar);
		
		btnCreate.setActionCommand(CREATEEVE);
		activePanel.add(btnCreate);
		
		btnDelete = new JButton("Delete event");
		btnDelete.addActionListener(actionController);
		btnDelete.setActionCommand(DELETEEVE);
		activePanel.add(btnDelete);
		
		btnBack = new JButton("Week View");
		btnBack.addActionListener(actionController);
		btnBack.setActionCommand(WEEK);
		activePanel.add(btnBack);
		
	}	

	public void refreshEvents(Object[][] data,String[] header) {
		
		if(calTable != null){
			eventPanel.remove(calTable);
			eventPanel.remove(scrollPane);
		}
		calTable = new JTable(data,header);
		calTable.setPreferredScrollableViewportSize(new Dimension(780,70));
		calTable.setFillsViewportHeight(true);
		
		scrollPane = new JScrollPane(calTable);
		scrollPane.setBounds(26,30,930,280);
		eventPanel.add(scrollPane, BorderLayout.EAST);
		
	}
	public void removeTable() {
		eventPanel.remove(calTable);
		eventPanel.remove(scrollPane);
	}
}