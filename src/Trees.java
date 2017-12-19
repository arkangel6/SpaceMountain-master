import java.awt.Graphics;

public class Trees extends GameObject {
	double yvel = 0;
	double gravity = 0.01;
	static boolean slow = false;
	static boolean fast = false;
	public Trees(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	//int y = 500;
	void update() {
		
		 
		super.update();
		 if(slow) {
		 	y = y -1;
		 }
		 else if(fast) {
			 y = y - 20;
		 }
		 else {
			 y = y-3; 
		 
		 }
		
		//System.out.println(y);

		/*
		y -= yvel;
		y += gravity;
		gravity += 0.05;
		System.out.println(yvel);
	
*/
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.treeImg, x, y, width, height, null);
	}

}
