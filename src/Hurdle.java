import java.awt.Graphics;

public class Hurdle extends GameObject{
	
	
	static boolean hurdlefast = false;
	public Hurdle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update(){
		super.update();
		if(hurdlefast){
		y = y - 20;
		}else{
		y = y - 3;
		}
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.hurdleImg, x, y, width, height, null);
	}
}
