import java.awt.Graphics;

public class Trees extends GameObject {
	double yvel = 0;
	double gravity = 0.1;

	public Trees(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	void update() {

		y--;

	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.treeImg, x, y, width, height, null);
	}

}
