package view;

import javax.swing.JPanel;

import controller.ActionController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CalendarDay extends JPanel{
	
	public static final String WEEK = "week";
	public static final String NOTE = "note";
	public static final String SET = "set";
	
	private ActionController actionController;
	private JLabel lblDayView;
	private JPanel eventPanel;
	private JPanel activePanel;
	private JTable eventTable;
	private JScrollPane eventScroll;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnBack;
	private JButton btnNote;
	private JButton btnSet;
	private JLabel forecastLbl;
	private JLabel noteLbl;
	private JTextField setTxtField;
	private JPanel bottomPanel;
	private JPanel infoPanel;
	
	public CalendarDay (ActionController actionController) {
		this.actionController = actionController;
		setLayout(new BorderLayout());
		
		lblDayView = new JLabel("Day view");
		lblDayView.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayView, BorderLayout.NORTH);
		
		
		eventPanel = new JPanel();
		add(eventPanel, BorderLayout.CENTER);
		eventPanel.setLayout(new BorderLayout(0, 0));
		
		bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		activePanel = new JPanel();
		bottomPanel.add(activePanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("Create event");
		activePanel.add(btnCreate);
		
		btnDelete = new JButton("Delete event");
		activePanel.add(btnDelete);
		
		btnBack = new JButton("Week View");
		btnBack.addActionListener(actionController);
		btnBack.setActionCommand(WEEK);
		activePanel.add(btnBack);
		
		btnNote = new JButton("View note");
		btnNote.addActionListener(actionController);
		btnNote.setActionCommand(NOTE);
		activePanel.add(btnNote);
		
		infoPanel = new JPanel();
		bottomPanel.add(infoPanel, BorderLayout.NORTH);
		
		forecastLbl = new JLabel("");
		forecastLbl.setHorizontalAlignment(SwingConstants.LEFT);
		infoPanel.add(forecastLbl, BorderLayout.BEFORE_FIRST_LINE);
		
		noteLbl = new JLabel("");
		infoPanel.add(noteLbl);
		noteLbl.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnSet = new JButton("Create new note");
		infoPanel.add(btnSet);
		btnSet.setVisible(false);
		btnSet.addActionListener(actionController);
		btnSet.setActionCommand(SET);
		
		setTxtField = new JTextField();
		setTxtField.setText("\"Add new note\"");
		infoPanel.add(setTxtField);
		setTxtField.setVisible(false);
		
		
	}

	public void refreshEvents(Object[][] data,String[] header) {
		
		if(eventTable != null){
			eventPanel.remove(eventTable);
			eventPanel.remove(eventScroll);
		}
		eventTable = new JTable(data,header);
		eventTable.setPreferredScrollableViewportSize(new Dimension(800,70));
		eventTable.setFillsViewportHeight(true);
		
		eventScroll = new JScrollPane(eventTable);
		eventScroll.setBounds(26,30,930,280);
		eventPanel.add(eventScroll);
		
	}
	
	public void removeTable() {
		eventPanel.remove(eventTable);
		eventPanel.remove(eventScroll);
	}
	
	public JLabel getLblDayView() {
		return lblDayView;
	}

	public void setLblDayView(JLabel lblDayView) {
		this.lblDayView = lblDayView;
	}

	public JPanel getEventPanel() {
		return eventPanel;
	}

	public void setEventPanel(JPanel eventPanel) {
		this.eventPanel = eventPanel;
	}

	public JPanel getActivePanel() {
		return activePanel;
	}

	public void setActivePanel(JPanel activePanel) {
		this.activePanel = activePanel;
	}
	public JLabel getForecastLbl() {
		return forecastLbl;
	}

	public void setForecastLbl(JLabel forecastLbl) {
		this.forecastLbl = forecastLbl;
	}

	public JLabel getNoteLbl() {
		return noteLbl;
	}

	public void setNoteLbl(JLabel noteLbl) {
		this.noteLbl = noteLbl;
	}

	public JButton getBtnSet() {
		return btnSet;
	}

	public void setBtnSet(JButton btnSet) {
		this.btnSet = btnSet;
	}

	public JTextField getSetTxtField() {
		return setTxtField;
	}

	public void setSetTxtField(JTextField setTxtField) {
		this.setTxtField = setTxtField;
	}

}
