import javax.swing.JFrame;

import view.Screen;

public class Main {

	public static void main(String[] args) {
		
		//Start application
		Screen screen = new Screen();
		
		screen.setTitle("CBS calendar v2");
        screen.setLocationRelativeTo(null);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        screen.setVisible(true);
	}
}
