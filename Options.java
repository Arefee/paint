import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.OptionPaneUI;

public class Options {

	private JFrame optionsWindow;
	private JPanel optionsPanel;
	private JSlider redSlider, greenSlider, blueSlider, widthSlider, heightSlider;
	private OptionsListener optionsListener;
	private JButton Circle, Square, fill;
	private int currentTool;
	public static final int WIDTH_Options = 220;

	public Options() {
		Fields();
		setAttributes();
		addStuffToPanel();
		Options_Window();
	}

	private void Fields() {
		optionsWindow = new JFrame("Options");
		optionsPanel = new JPanel();
		redSlider = new JSlider(0, 255);
		greenSlider = new JSlider(0, 255);
		blueSlider = new JSlider(0, 255);
		widthSlider = new JSlider(0, 100);
		heightSlider = new JSlider(0, 100);
		optionsListener = new OptionsListener();
		Circle = new JButton("Circle");
		Square = new JButton("Square");
		fill = new JButton("Fill");
		currentTool = Tool.CircleTool;
	}

	public void setAttributes() {

		redSlider.setBorder(BorderFactory.createTitledBorder("Red"));
		redSlider.setMajorTickSpacing(100);
		redSlider.setValue(100);
		redSlider.setPaintTicks(true);
		redSlider.setPaintLabels(true);
		redSlider.addChangeListener(optionsListener);

		greenSlider.setBorder(BorderFactory.createTitledBorder("Green"));
		greenSlider.setMajorTickSpacing(100);
		greenSlider.setValue(100);
		greenSlider.setPaintTicks(true);
		greenSlider.setPaintLabels(true);
		greenSlider.addChangeListener(optionsListener);

		blueSlider.setBorder(BorderFactory.createTitledBorder("Blue"));
		blueSlider.setMajorTickSpacing(100);
		blueSlider.setValue(100);
		blueSlider.setPaintTicks(true);
		blueSlider.setPaintLabels(true);
		blueSlider.addChangeListener(optionsListener);

		widthSlider.setBorder(BorderFactory.createTitledBorder("Width"));
		widthSlider.setMajorTickSpacing(20);
		widthSlider.setValue(1);
		widthSlider.setPaintTicks(true);
		widthSlider.setPaintLabels(true);
		widthSlider.addChangeListener(optionsListener);

		heightSlider.setBorder(BorderFactory.createTitledBorder("Height"));
		heightSlider.setMajorTickSpacing(20);
		heightSlider.setValue(2);
		heightSlider.setPaintTicks(true);
		heightSlider.setPaintLabels(true);
		heightSlider.addChangeListener(optionsListener);

		Circle.addActionListener(optionsListener);
		Square.addActionListener(optionsListener);
		fill.addActionListener(optionsListener);

	}

	private void addStuffToPanel() {
		optionsPanel.add(redSlider);
		optionsPanel.add(greenSlider);
		optionsPanel.add(blueSlider);
		optionsPanel.add(widthSlider);
		optionsPanel.add(heightSlider);
		optionsPanel.add(Circle);
		optionsPanel.add(Square);
		optionsPanel.add(fill);

	}

	public void Options_Window() {
		optionsWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionsWindow.setResizable(false);
		optionsWindow.setSize(WIDTH_Options, PanelDemo.height);

		Point locationPoint = PanelDemo.getWindowLocation();
		locationPoint.setLocation(locationPoint.getX() - WIDTH_Options + 10, locationPoint.getY());
		optionsWindow.setLocation(locationPoint);
		optionsWindow.add(optionsPanel);
		optionsWindow.setVisible(true);

	}

	public int getRedValue() {
		return redSlider.getValue();
	}

	public int getGreenValue() {
		return greenSlider.getValue();
	}

	public int getBlueValue() {
		return blueSlider.getValue();
	}

	public int getWidthValue() {
		return widthSlider.getValue();
	}

	public int getHeightValue() {
		return heightSlider.getValue();
	}

	public int getCurrentTool() {
		return currentTool;

	}

	private class OptionsListener implements ChangeListener, ActionListener {

		public void stateChanged(ChangeEvent e) {

			int red = redSlider.getValue();
			int green = greenSlider.getValue();
			int blue = blueSlider.getValue();

			Color color = new Color(red, green, blue);

			optionsPanel.setBackground(color);

		}

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == Circle) {
				currentTool = Tool.CircleTool;
			}
			if (e.getSource() == Square) {
				currentTool = Tool.SquareTool;
			}
			if (e.getSource() == fill) {
				currentTool = Tool.FillTool;
			}
		}
	}
}
