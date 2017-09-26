import java.awt.Color;
import java.awt.Graphics;

public class Unicorn extends GameObject{
 
	public Unicorn(int x, int y, int width, int height){
		super(x, y, width, height);
	}
	static void update(String direction){
		
		//super.update();
		if(direction.equals("space")) {
			
			System.out.println("space");
		}}
		
	void draw(Graphics g){
		//g.setColor(Color.YELLOW);
		//g.fillRect(150, 0, 50, 50);
		g.drawImage(GamePanel.unicornImg, x, y, width, height, null);
	}
}
