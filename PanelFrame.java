import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class PanelFrame extends JPanel {

	private Listener listener;
	private Options optionsWindow;
	private Graphics2D graphics2d;
	private BufferedImage image;

	private Color toolColor;
	private int toolX, toolY, toolRed, toolGreen, toolBlue, toolWidth, toolHeight;
	private List<Tool> strokes;

	public static final int Scale = 8;

	public PanelFrame(Options optionsWindow) {
		this.optionsWindow = optionsWindow;
		listener = new Listener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		image = new BufferedImage(PanelDemo.width / Scale, PanelDemo.height / Scale, BufferedImage.TYPE_INT_RGB);
		graphics2d = (Graphics2D) image.getGraphics();
		strokes = new ArrayList<Tool>();
		Draw();
		repaint();
	}

	public void paintComponent(Graphics graphics) {

		graphics.drawImage(image, 0, 0, PanelDemo.width, PanelDemo.height, null);

	}

	public void Draw() {

		Background();
		Strokes();
	}

	private void Background() {

		graphics2d.setColor(Color.WHITE);
		graphics2d.fillRect(0, 0, PanelDemo.width, PanelDemo.height);

	}

	private void Strokes() {

		for (Tool tool : strokes) {
			tool.setAttributes(graphics2d);
			tool.draw(graphics2d);
		}
	}

	public void addStroke(MouseEvent e) {
		toolX = e.getX() / Scale;
		toolY = e.getY() / Scale;
		toolWidth = optionsWindow.getWidthValue();
		toolHeight = optionsWindow.getHeightValue();
		toolRed = optionsWindow.getRedValue();
		toolGreen = optionsWindow.getGreenValue();
		toolBlue = optionsWindow.getBlueValue();
		toolColor = new Color(toolRed, toolGreen, toolBlue);

		if (optionsWindow.getCurrentTool() == Tool.CircleTool) {
			strokes.add(new Circle(toolX, toolY, toolWidth, toolHeight, toolColor));
		} else if (optionsWindow.getCurrentTool() == Tool.SquareTool) {
			strokes.add(new Square(toolX, toolY, toolWidth, toolHeight, toolColor));
		} else if (optionsWindow.getCurrentTool() == Tool.FillTool) {
			strokes.add(new Fill(toolX, toolY, toolWidth, toolHeight, toolColor, image));
		}

		Draw();
		repaint();
	}

	private class Listener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {

		}

		public void mouseEntered(MouseEvent e) {

		}

		public void mouseExited(MouseEvent e) {

		}

		public void mousePressed(MouseEvent e) {
			addStroke(e);

		}

		public void mouseReleased(MouseEvent e) {

		}

		public void mouseDragged(MouseEvent e) {
			addStroke(e);
		}

		public void mouseMoved(MouseEvent e) {

		}

	}

}
