import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Fill extends Tool {

	private BufferedImage image;
	private int oldColor, newColor;

	public Fill(int x, int y, int width, int height, Color color, BufferedImage image) {
		super(x, y, width, height, color);
		oldColor = image.getRGB(x, y);
		newColor = color.getRGB();
		this.image=image;
	}

	
	public void flood(int x, int y) {

		if (x < 0)
			return;
		if (y < 0)
			return;
		if (x >= image.getWidth())
			return;
		if (y >= image.getHeight())
			return;
		if (image.getRGB(x, y) != oldColor)
			return;
		image.setRGB(x, y, newColor);
		flood(x - 1, y);
		flood(x + 1, y);
		flood(x, y - 1);
		flood(x, y + 1);
	}
	
	public void draw(Graphics2D graphics2d) {

		flood(x, y);
	}


}
