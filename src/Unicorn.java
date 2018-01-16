import java.awt.Color;
import java.awt.Graphics;

public class Unicorn extends GameObject {
	double yvel = 0.2;
	double gravity = 1;
	
	public static boolean left = false;
	ObjectManager manager;
	int rightvalue;
	public Unicorn(int x, int y, int width, int height) {
		super(x, y, width, height);
		manager = new ObjectManager();
	}

	void update(String direction) {

		// super.update();
		// if(direction.equals("space")) {

		// System.out.println("space");
		// }}
		
		super.update();
		if (direction.equals("right")) {
			
			
			manager.setRight(rightvalue++);
			
			
				x = x + manager.getRight();
			
			
			
			
			/*x += yvel;
			yvel += gravity;
			*/
			

			//System.out.println(x);
		} else if (direction.equals("left")) {
			
			
			x = x - 10;
			
			/*
			x -= yvel;
			yvel += gravity;
			
			*/
			//System.out.println("lllllllllllllllllllll");
			
		}
		else {
			manager.setRight(0);
			rightvalue = manager.getRight();
		}

	}

	void draw(Graphics g) {
		// g.setColor(Color.YELLOW);
		// g.fillRect(150, 0, 50, 50);
		if(left) {
			g.drawImage(GamePanel.unicorn2Img, x, y, width, height, null);	
		}
		else {
		g.drawImage(GamePanel.unicornImg, x, y, width, height, null);
		}
		/*g.setColor(Color.yellow);
		g.drawRect((int) collisionBox.getX(), (int) collisionBox.getY(), (int) collisionBox.getWidth(),
				(int) collisionBox.getHeight());*/
	}
}
