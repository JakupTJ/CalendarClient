package view;

import javax.swing.JPanel;

import controller.ActionController;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class CalendarDay extends JPanel{
	
	public static final String BACK = "back";
	
	private ActionController actionController;
	private JLabel lblDayView;
	private JPanel eventPanel;
	private JPanel activePanel;
	private JTable resultTable;
	private JScrollPane scrollPane;
	private JButton btnCreate;
	private JButton btnDelete;
	private JButton btnBack;
	
	public CalendarDay (ActionController actionController) {
		this.actionController = actionController;
		setLayout(new BorderLayout());
		
		lblDayView = new JLabel("Day view");
		lblDayView.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayView, BorderLayout.NORTH);
		
		
		eventPanel = new JPanel();
		eventPanel.setVisible(true);
		add(eventPanel, BorderLayout.CENTER);
		
		activePanel = new JPanel();
		add(activePanel, BorderLayout.SOUTH);
		
		btnCreate = new JButton("Create event");
		activePanel.add(btnCreate);
		
		btnDelete = new JButton("Delete event");
		activePanel.add(btnDelete);
		
		btnBack = new JButton("Week View");
		btnBack.addActionListener(actionController);
		btnBack.setActionCommand(BACK);
		activePanel.add(btnBack);
		
		
		
	}
	
	public void refreshEvents(Object[][] data,String[] columnNames) {
		
		if(resultTable != null){
			this.remove(resultTable);
			this.remove(scrollPane);
		}
		resultTable = new JTable(data,columnNames);
		resultTable.setPreferredScrollableViewportSize(new Dimension(800,70));
		resultTable.setFillsViewportHeight(true);
		
		scrollPane = new JScrollPane(resultTable);
		scrollPane.setBounds(26,30,398,120);
		eventPanel.add(scrollPane);
		
	}
	
	public void removeTable() {
		this.remove(resultTable);
		this.remove(scrollPane);
	}

}
