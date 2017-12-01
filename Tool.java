import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Tool {

	protected int x, y, width, height;
	protected Color color;

	public static final int CircleTool = 1;
	public static final int SquareTool = 2;
	public static final int FillTool = 3;

	public Tool(int x, int y, int width, int height, Color color) {
		this.x = x - width / 2;
		this.y = y - height / 2;
		this.width = width;
		this.height = height;
		this.color = color;

	}

	public void setAttributes(Graphics2D graphics2d) {
		graphics2d.setColor(color);

	}

	public abstract void draw(Graphics2D graphics2d);

}
