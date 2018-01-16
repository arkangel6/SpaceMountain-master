import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends GameObject{

	
		int speed = 10;
	public Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update() {
		super.update();
		y+=speed;
		if(y < 0) {
			isAlive = false;
		}
		
	}
	
	void draw(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillRect(x - 3, y, width , height);
		g.setColor(Color.ORANGE);
		g.fillRect(x - 2, y + 5, width , height);
		
		g.setColor(Color.YELLOW);
		g.fillRect(x - 1, y + 10, width , height);
		
		g.setColor(Color.GREEN);
		g.fillRect(x , y + 15, width , height);
		
		g.setColor(Color.BLUE);
		g.fillRect(x +1, y + 20, width , height);
		
		g.setColor(Color.MAGENTA);
		g.fillRect(x + 2, y + 25, width , height);
		
		
	}
	
	
	
	
	

}
