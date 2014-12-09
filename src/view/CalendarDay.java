package view;

import javax.swing.JPanel;
import controller.ActionController;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Font;

public class CalendarDay extends JPanel{
	
	public static final String WEEK = "week";
	public static final String NOTE = "note";
	public static final String SETNOTE = "setnote";
	public static final String EVENTSETTING = "eventSetting";
	public static final String DELNOTE = "delnote";
	
	private ActionController actionController;
	private JLabel lblDayView;
	private JPanel eventPanel;
	private JPanel activePanel;
	private JTable eventTable;
	private JScrollPane eventScroll;
	private JButton btnEventSetting;
	private JButton btnBack;
	private JButton btnNote;
	private JButton btnSet;
	private JButton btnDelNote;
	private JTextArea noteTxt;
	private JTextField setTxtField;
	private JPanel bottomPanel;
	private JPanel infoPanel;
	private JPanel notePanel;
	private JPanel ForecastPanel;
	private JLabel lblDesc;
	private JLabel lblLblcelc;
	
	public CalendarDay (ActionController actionController) {
		this.actionController = actionController;
		setSize(Screen.WITDH,Screen.HEIGHT);
		setLayout(new BorderLayout());
		
		lblDayView = new JLabel("Day view");
		lblDayView.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDayView.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblDayView, BorderLayout.NORTH);
		
		
		eventPanel = new JPanel();
		add(eventPanel, BorderLayout.CENTER);
		eventPanel.setLayout(new BorderLayout(0, 0));
		
		notePanel = new JPanel();
		notePanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, new Color(51, 153, 255), SystemColor.textHighlight, SystemColor.textHighlight, SystemColor.textHighlight));
//		panel.setBorder(new EmptyBorder(30, 30, 30, 30));
		notePanel.setMaximumSize(new Dimension(1000, 100));
		notePanel.setPreferredSize(new Dimension(300, 100));
		notePanel.setMinimumSize(new Dimension(1, 100));
		notePanel.setVisible(false);
		eventPanel.add(notePanel, BorderLayout.EAST);
		
		noteTxt = new JTextArea("");
		noteTxt.setBackground(SystemColor.control);
		noteTxt.setEditable(false);
		noteTxt.setWrapStyleWord(true);
	    noteTxt.setLineWrap(true);
	    noteTxt.setVisible(false);
		notePanel.add(noteTxt);
		
		bottomPanel = new JPanel();
		add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BorderLayout(0, 0));
		
		activePanel = new JPanel();
		bottomPanel.add(activePanel, BorderLayout.SOUTH);
		
		btnEventSetting = new JButton("Event Settings");
		btnEventSetting.addActionListener(actionController);
		btnEventSetting.setActionCommand(EVENTSETTING);
		activePanel.add(btnEventSetting);
		
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
		infoPanel.setLayout(new GridLayout(0, 4, 0, 0));
		
		ForecastPanel = new JPanel();
		infoPanel.add(ForecastPanel);
		ForecastPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblDesc = new JLabel("New label");
		ForecastPanel.add(lblDesc);
		
		lblLblcelc = new JLabel("lblCelc");
		ForecastPanel.add(lblLblcelc);
		
		btnSet = new JButton("Create new note");
		infoPanel.add(btnSet);
		btnSet.setVisible(false);
		btnSet.addActionListener(actionController);
		btnSet.setActionCommand(SETNOTE);
		
		btnDelNote = new JButton("Delete Note");
		btnDelNote.setVisible(false);
		btnDelNote.addActionListener(actionController);
		btnDelNote.setActionCommand(DELNOTE);
		infoPanel.add(btnDelNote);
		
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

	public JTextArea getNoteLbl() {
		return noteTxt;
	}

	public void setNoteTxt(JTextArea noteTxt) {
		this.noteTxt = noteTxt;
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



	public JPanel getNotePanel() {
		return notePanel;
	}



	public void setNotePanel(JPanel notePanel) {
		this.notePanel = notePanel;
	}



	public JButton getBtnDelNote() {
		return btnDelNote;
	}



	public void setBtnDelNote(JButton btnDelNote) {
		this.btnDelNote = btnDelNote;
	}



	public void setLblDesc(JLabel lblDesc) {
		this.lblDesc = lblDesc;
	}



	public void setLblLblcelc(JLabel lblLblcelc) {
		this.lblLblcelc = lblLblcelc;
	}



	public JLabel getLblDesc() {
		return lblDesc;
	}



	public JLabel getLblLblcelc() {
		return lblLblcelc;
	}

}
