import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	boolean isAlive = true;
	Rectangle collisionBox;

	public GameObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.collisionBox= new Rectangle(x, y, width, height);
	}

	void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	void update() {
		// TODO Auto-generated method stub
		collisionBox.setBounds(x, y, width, height);
	}
}
