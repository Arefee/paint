import java.awt.Point;

import javax.swing.JFrame;

public class PanelDemo {

	private static JFrame window;
	public static final int width = 1000, height = 800;
	private static PanelFrame Panel;
	private static Options optionsWindow;

	public static void main(String[] args) {

		
		window = new JFrame("Flood Fill");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(width, height);
		window.setLocationRelativeTo(null);
		optionsWindow= new Options();
		Panel = new PanelFrame(optionsWindow);
		window.setResizable(true);
		window.add(Panel);
		window.setVisible(true);
	}

	public static Point getWindowLocation() {
		return window.getLocation();

	}

}
