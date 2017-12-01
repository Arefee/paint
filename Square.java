import java.awt.Color;
import java.awt.Graphics2D;

public class Square extends Tool{

	public Square(int x, int y, int width, int height, Color color) {
		super(x, y, width, height, color);
	}

	public void draw(Graphics2D graphics2d) {

		graphics2d.fillRect(x, y, width, height);
	}

}
