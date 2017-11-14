import java.awt.Color;
import java.awt.Graphics;

public class Rainbow extends GameObject {

	int speed = 10;

	public Rainbow(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {
		super.update();
		y -= speed;
		if (y < 0) {
			isAlive = false;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		g.setColor(Color.ORANGE);
		g.fillRect(x - 7, y, width, height);
		g.setColor(Color.YELLOW);
		g.fillRect(x - 14, y, width, height);
		g.setColor(Color.GREEN);
		g.fillRect(x - 21, y, width, height);
		g.setColor(Color.BLUE);
		g.fillRect(x - 28, y, width, height);
		g.setColor(Color.MAGENTA);
		g.fillRect(x - 31, y, width * 2 / 3, height);

	}

}
