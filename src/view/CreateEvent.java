package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ActionController;
import javax.swing.SwingConstants;


public class CreateEvent extends JPanel {
	
	public final static String ADDEVENT = "addevent";

	private Screen screen;
	private ActionController actionController;

	private JLabel lblShow;
	private JLabel lblBackground;
	private JLabel lblBTCLogo;
	private JLabel lblCBSLogo;

	private JTextField txtStartTime;
	private JTextField txtEndTime;
	private JTextField txtLocation;
	private JTextField txtTitle;
	private JTextField txtDesc;

	private JButton btnAddEvent;

	// constructor
	public CreateEvent(ActionController actionController) {
		this.actionController = actionController;

		// sets absolutelayout
		setLayout(null);
		// sets the defined size
		setSize(Screen.WITDH, Screen.HEIGHT);

		lblShow = new JLabel("Create Event");
		lblShow.setHorizontalAlignment(SwingConstants.CENTER);
		lblShow.setBounds(290, 6, 297, 31);
		add(lblShow);

		txtTitle = new JTextField();
		txtTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitle.setText("Title");
		txtTitle.setBounds(99, 60, 134, 28);
		add(txtTitle);

		txtDesc = new JTextField();
		txtDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesc.setText("Description");
		txtDesc.setBounds(371, 60, 134, 28);
		add(txtDesc);

		btnAddEvent = new JButton("Create Event");
		btnAddEvent.setBounds(371, 274, 134, 42);
		btnAddEvent.addActionListener(actionController);
		btnAddEvent.setActionCommand(ADDEVENT);
		add(btnAddEvent);

		txtStartTime = new JTextField();
		txtStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtStartTime.setText("Start time");
		txtStartTime.setBounds(230, 139, 134, 28);
		add(txtStartTime);

		txtEndTime = new JTextField();
		txtEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtEndTime.setText("End time");
		txtEndTime.setBounds(507, 139, 134, 28);
		add(txtEndTime);

		txtLocation = new JTextField();
		txtLocation.setHorizontalAlignment(SwingConstants.CENTER);
		txtLocation.setText("Location");
		txtLocation.setBounds(645, 60, 134, 28);
		add(txtLocation);

	}// end constructor

}
