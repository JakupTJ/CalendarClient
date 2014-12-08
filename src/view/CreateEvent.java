package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import controller.ActionController;
import javax.swing.SwingConstants;
import java.awt.Font;

public class CreateEvent extends JPanel {

	public final static String ADDEVENT = "addEvent";
	public final static String DELEVENT = "delEvent";
	public final static String DAYVIEW = "dayView";

	private ActionController actionController;

	private JPanel eventPanel;
	private JPanel bottomPanel;
	private JButton btnAddEvent;
	private JButton btnDelEvent;
	private JButton btnDayView;
	
	private JLabel lblShow;
	private JLabel lblEventInformation;
	private JLabel lblTitle;
	private JLabel lblDescription;
	private JLabel lblLocation;
	private JLabel lblStartTime;
	private JLabel lblEndtime;
	private JTextField txtTitle;
	private JTextField txtEndHour;
	private JTextField txtStartHour;
	private JTextField txtDescription;
	private JTextField txtLocation;
	private JTextField txtStartMin;
	private JTextField txtEndMin;


	// constructor
	public CreateEvent(ActionController actionController) {
		this.actionController = actionController;
		// sets the defined size
		setSize(Screen.WITDH, Screen.HEIGHT);
		setLayout(null);

		lblShow = new JLabel("Create Event");
		lblShow.setBounds(418, 0, 73, 16);
		lblShow.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblShow);

		eventPanel = new JPanel();
		eventPanel.setBounds(0, 0, 950, 285);
		add(eventPanel);
		eventPanel.setLayout(null);
		
		lblEventInformation = new JLabel("Event information:");
		lblEventInformation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,13));
		lblEventInformation.setBounds(48, 29, 120, 16);
		eventPanel.add(lblEventInformation);

		txtTitle = new JTextField("");
		txtTitle.setBounds(178, 60, 150, 30);
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		eventPanel.add(txtTitle);


		txtDescription = new JTextField("");
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setBounds(178, 99, 150, 30);
		eventPanel.add(txtDescription);

		txtLocation = new JTextField("");
		txtLocation.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocation.setBounds(178, 136, 150, 30);
		eventPanel.add(txtLocation);

		txtStartHour = new JTextField("");
		txtStartHour.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartHour.setBounds(178, 179, 56, 30);
		eventPanel.add(txtStartHour);

		txtEndHour = new JTextField("");
		txtEndHour.setHorizontalAlignment(SwingConstants.CENTER);
		txtEndHour.setBounds(178, 222, 56, 30);
		eventPanel.add(txtEndHour);

		lblTitle = new JLabel("Title:");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(48, 67, 105, 16);
		eventPanel.add(lblTitle);

		lblDescription = new JLabel("Description:");
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(48, 106, 105, 16);
		eventPanel.add(lblDescription);

		lblLocation = new JLabel("Location:");
		lblLocation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocation.setBounds(48, 143, 105, 16);
		eventPanel.add(lblLocation);

		lblStartTime = new JLabel("Start[HH:MM]:");
		lblStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblStartTime.setBounds(48, 186, 105, 16);
		eventPanel.add(lblStartTime);

		lblEndtime = new JLabel("End time[HH:MM]:");
		lblEndtime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndtime.setBounds(48, 229, 105, 16);
		eventPanel.add(lblEndtime);
		
		txtStartMin = new JTextField("");
		txtStartMin.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartMin.setBounds(272, 179, 56, 30);
		eventPanel.add(txtStartMin);
		
		txtEndMin = new JTextField("");
		txtEndMin.setHorizontalAlignment(SwingConstants.CENTER);
		txtEndMin.setBounds(272, 222, 56, 30);
		eventPanel.add(txtEndMin);

		bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 285, 950, 35);
		add(bottomPanel);

		btnAddEvent = new JButton("Create Event");
		btnAddEvent.addActionListener(actionController);
		btnAddEvent.setActionCommand(ADDEVENT);
		bottomPanel.add(btnAddEvent);


		btnDelEvent = new JButton("Delete Event");
		btnDelEvent.addActionListener(actionController);
		btnDelEvent.setActionCommand(DELEVENT);
		bottomPanel.add(btnDelEvent);
		
		btnDayView = new JButton("Day view");
		btnDayView.addActionListener(actionController);
		btnDayView.setActionCommand(DAYVIEW);
		bottomPanel.add(btnDayView);


	}// end constructor
	
public void clearFields(){
	txtTitle.setText("");
	txtEndHour.setText("");
	txtStartHour.setText("");
	txtDescription.setText("");
	txtLocation.setText("");
	txtStartMin.setText("");
	txtEndMin.setText("");	
		
	}


	public JTextField getTxtTitle() {
		return txtTitle;
	}


	public void setTxtEndTime(JTextField txtTitle) {
		this.txtTitle = txtTitle;
	}


	public JTextField getTxtEndHour() {
		return txtEndHour;
	}


	public void setTxtEndHour(JTextField txtEndHour) {
		this.txtEndHour = txtEndHour;
	}


	public JTextField getTxtStartHour() {
		return txtStartHour;
	}


	public void setTxtStartHour(JTextField txtStartHour) {
		this.txtStartHour = txtStartHour;
	}


	public JTextField getTxtDescription() {
		return txtDescription;
	}


	public void setTxtDescription(JTextField txtDescription) {
		this.txtDescription = txtDescription;
	}


	public JTextField getTxtLocation() {
		return txtLocation;
	}


	public void setTxtLocation(JTextField txtLocation) {
		this.txtLocation = txtLocation;
	}


	public JTextField getTxtStartMin() {
		return txtStartMin;
	}


	public void setTxtStartMin(JTextField txtStartMin) {
		this.txtStartMin = txtStartMin;
	}


	public JTextField getTxtEndMin() {
		return txtEndMin;
	}


	public void setTxtEndMin(JTextField txtEndMin) {
		this.txtEndMin = txtEndMin;
	}
}
