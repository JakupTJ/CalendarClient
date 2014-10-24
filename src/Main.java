import javax.swing.JFrame;

import View.Screen;

public class Main {

	public static void main(String[] args) {
		
		Screen screen = new Screen();
		screen.setVisible(true);
		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
