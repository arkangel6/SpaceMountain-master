import java.awt.Graphics;

public class leftHurdle extends GameObject{
	
	
	static boolean hurdlefast2 = false;
	public leftHurdle(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}
	void update(){
		super.update();
		if(hurdlefast2){
		y = y - 20;
		}else{
		y = y - 3;
		}
	}
	
	void draw(Graphics g) {
		g.drawImage(GamePanel.hurdleleftImg, x, y, width, height, null);
	}
}
