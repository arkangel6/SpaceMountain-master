import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	private BufferedImage background;
	private int backgroundHeight = 0;
	int frameWidth;
	int frameHeight;
	int y1 = 0;
	int y2 = 500;
	int x = 0;
	int y;
	int score;
	Unicorn unicorn = new Unicorn(150, 20, 50, 50);
	ObjectManager manager;
	Rainbow rainbow;
	int right;
	final int menu = 0;
	final int game = 1;
	final int end = 2;
	final int instruction = 3;
	int current_state = menu;
	static boolean scrollfast = false;
	public static boolean rainbowleft = false;
	Projectile projectile;
	// GamePanel
	public static BufferedImage unicornImg;
	public static BufferedImage treeImg;
	public static BufferedImage boostImg;
	public static BufferedImage hurdleImg;
	public static BufferedImage hurdleleftImg;
	public static BufferedImage unicorn2Img;
	public static BufferedImage menuscreenImg;
	public static BufferedImage endscreenImg;
	public static BufferedImage instructionsImg;
	
	int z = 0;
	public GamePanel(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		Timer timer = new Timer(1000 / 60, this);
		timer.addActionListener(this);

		manager = new ObjectManager();
		manager.addObject(unicorn);

		try {

			background = ImageIO.read(getClass().getResource("pixel2.jpg"));
			backgroundHeight = background.getHeight();
			// System.out.println(backgroundHeight);

			treeImg = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
			unicornImg = ImageIO.read(this.getClass().getResourceAsStream("rainbowdash.png"));
			unicorn2Img = ImageIO.read(this.getClass().getResourceAsStream("rainbowdash2.png"));
			boostImg = ImageIO.read(this.getClass().getResourceAsStream("boost2.png"));
			hurdleImg = ImageIO.read(this.getClass().getResourceAsStream("rightskigate.png"));
			hurdleleftImg = ImageIO.read(this.getClass().getResourceAsStream("leftskigate2.png"));
			menuscreenImg = ImageIO.read(this.getClass().getResourceAsStream("finalmenu.png"));
			endscreenImg = ImageIO.read(this.getClass().getResourceAsStream("endscreen.png"));
			instructionsImg = ImageIO.read(this.getClass().getResourceAsStream("instructions.png"));
			
			System.out.println("no background image");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer.start();
		if (timer.isRunning()) {
			System.out.println("true");
		}

	}

	void updateGameState() {
		manager.update();
		manager.manageTrees();
		
		if(ObjectManager.fast2){
			manager.setScore(score++);
			manager.setScore(score++);
			manager.setScore(score++);
			manager.setScore(score++);
			manager.setScore(score++);
		}
		else{
		manager.setScore(score++);
		}
		
		if(ObjectManager.extra) {
			for (int i = 0; i < 10; i++) {
				manager.setScore(score++);
				}
				ObjectManager.extra = false;
		}
		
		
		
		
		
		if(ObjectManager.rightskigate){
			for (int i = 0; i < 10; i++) {
			manager.setScore(score++);
			}
			ObjectManager.rightskigate = false;
		}
		if(ObjectManager.leftskigate){
			for (int i = 0; i < 10; i++) {
			manager.setScore(score++);
			}
			ObjectManager.leftskigate = false;
		}
		
		//manager.setRight(right++);
		
		if(rainbowleft) {
			z = -76;
		}
		else {
			z = 3;
		}
		
		manager.addObject(rainbow = new Rainbow(unicorn.x - z + x, unicorn.y - 5 + y, 10, 10));
		
		
		
		
		if(scrollfast) {
			scrollSpeed = 20;
			yvel = 20;
		}
		else {
			scrollSpeed = 3;
			yvel = 0;
		}
		
		manager.checkCollision();
		manager.checkCollisionHurdle();
		manager.checkCollisionTrees();
		if (unicorn.isAlive == false) {
			current_state = end;
			manager.reset(); 
			//unicorn = new Unicorn(150, 20, 50, 50);
			//manager.setScore(0);
			

		}

	}

	/*
	 * int random1 = 0; int random2 = 1; void randomRainbow() { random1++;
	 * if(random1 == random2) { manager.addObject(rainbow = new
	 * Rainbow(unicorn.x-15+x, unicorn.y-5+y, 10,10)); random2 = 0; } else {
	 * manager.addObject(rainbow = new Rainbow(unicorn.x-10+x, unicorn.y+y, 10,10));
	 * random2++; random1 = 0; } }
	 */
	void startagain() {
		unicorn = new Unicorn(150, 20, 50, 50);
		manager.addObject(unicorn);
		score = 0;
		manager.setScore(0);
		
		
	}

	void drawMenuState(Graphics g) {
		
		g.drawImage(menuscreenImg, 0, -20, frameWidth, frameHeight, null);
	
		
		// g.setFont(titleFont);
		// g.setColor(Color.WHITE);
		// g.drawString("", 100, 300);

	}
	
	void drawInstructionState(Graphics g) {
		//g.drawRect(0, 0, 800, 500);
		//g.setColor(Color.GREEN);
		//g.fillRect(0, 0, SpaceMountain.width, SpaceMountain.height);
		g.drawImage(instructionsImg, 0, -15, frameWidth, frameHeight, null);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospace", Font.BOLD, 25));
		g.drawString("go right", 200, 110);
		g.drawString("go left", 200, 150);
		g.drawString("shoot", 200, 210);
		g.drawString("go faster", 200, 270);
		g.drawString("bonus points", 200, 340);
		g.drawString("avoid", 200, 385);
		g.drawImage(boostImg, 55, 230, 60, 60, null);
		g.drawImage(hurdleImg, 45, 295, 490, 57, null);
		g.drawImage(hurdleleftImg, -370, 315, 490, 57, null);
		g.drawImage(treeImg, 55, 355, 55, 55, null);
		//g.setColor(Color.YELLOW);
		//g.drawString("press right arrow continiously to go right \n and left arrow continiously to go left and up arrow to shoot \n if you run into a tree you die \n if you run into a boost you go faster \n if you run past a skigate you get extra points", 20, 20);
	}

	void drawEndState(Graphics g) {
		
		//g.drawRect(0, 0, 800, 500);
		//g.setColor(Color.red);
		//g.fillRect(0, 0, SpaceMountain.width, SpaceMountain.height);
		
		//g.setColor(Color.BLACK);
		//g.setFont(new Font("Ariel", Font.BOLD, 80));
		//g.drawString("GAMEOVER :(", 120, 200);
		
		//g.setFont(new Font("Ariel", Font.BOLD, 30));
		//g.drawString("Press 4 to play again", 200, 400);
		
		g.drawImage(endscreenImg, 0, -20, frameWidth, frameHeight, null);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospace", Font.BOLD, 40));
		g.drawString("SCORE: " + manager.getScore(), 250, 350);
		
	}
	
	void drawGameState(Graphics g) {
		g.drawImage(background, 0, 0, frameWidth, frameHeight, 0/* + x */, y1, frameWidth /* + x */, y2, this);
		// System.out.println("paint");
		// unicorn g.drawImage(GamePanel.unicornImg, 120+x, 20+y, 50, 50, null);
		// unicorn = new Unicorn(150, 20, 50, 50);
		manager.draw(g);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospace", Font.PLAIN, 20));
		g.drawString("SCORE: " + manager.getScore(), 600, 30);
		
		if(ObjectManager.rightskigate){
			g.setFont(new Font("Ariel", Font.BOLD, 50));
			g.drawString("+300", 500, 200);
		}
		else{
			g.drawString("      ", 500, 200);
		}
		if(ObjectManager.leftskigate){
			g.setFont(new Font("Ariel", Font.BOLD, 50));
			g.drawString("+300", 300, 200);
		}
		else{
			g.drawString("      ", 500, 200);
		}
		
		if(ObjectManager.extra){
			g.setFont(new Font("Ariel", Font.BOLD, 50));
			g.drawString("+300", 500, 200);
		}
		else{
			g.drawString("      ", 500, 200);
		}
		
	}

	public void paintComponent(Graphics g) {
		if (current_state == menu) {
			drawMenuState(g);
		} else if (current_state == game) {
			drawGameState(g);
		} else if (current_state == end) {
			drawEndState(g);
		} else if(current_state == instruction) {
			drawInstructionState(g);
		}
	}

	/*
	 * public void paintComponent2(Graphics g) {
	 * 
	 * if(current_state == menu) { drawMenuState(g); } else if(current_state ==
	 * game) { paintComponent(g); } }
	 */

	void updateMenuState() {
		manager.setScore(0);
	}
	
	void updateInstructionState() {
		
	}

	void updateEndState() {

	}
	
	private int scrollSpeed = 3;
	double yvel = 0;
	double gravity = 0.01;

	public void moveBackground() {
		if (y1 >= (backgroundHeight - frameHeight)) {
			y1 = 0;
			y2 = frameHeight;
		} else {

			y1 += scrollSpeed;

			y2 += scrollSpeed;

			/*
			 * y1 += yvel; y2 += yvel; yvel += gravity;
			 * 
			 * 
			 * if (yvel >= 4) { // sets max speed at 4 y1 += 4; y2 += 4; yvel = 4; }
			 */

			// System.out.println(yvel);
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// moveBackground();
		// updateGameState();
		// System.out.println("actionperformed");
		repaint();

		if (current_state == menu) {
			updateMenuState();
		} else if (current_state == game) {
			updateGameState();
			moveBackground();
			System.out.println("actionperformed");
		} else if (current_state == end) {
			updateEndState();

		} else if(current_state == instruction) {
			updateInstructionState();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			current_state++;
			if (current_state > end) {
				current_state = menu;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_1) {

			 	//startagain();
				current_state = game;
			

		}
		if(e.getKeyCode() == KeyEvent.VK_4) {
			startagain();
			current_state = game;
		
			
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			
			current_state = instruction;
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			current_state = menu;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// Unicorn.update("space");
			scrollSpeed = 1;
			yvel = 1;
			System.out.println("space");
			Trees.slow = true;
			ObjectManager.slow2 = true;
			Boost.slow = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			unicorn.update("left");
			Unicorn.left = true;
			rainbowleft = true;
			// x = x - 10;

			/*
			 * if (x >= 5) { x = x - 5; } else { x = x; }
			 */
			System.out.println("left");
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			unicorn.update("right");
			Unicorn.left = false;
			rainbowleft = false;
			// x = x + 10;

			/*
			 * if (x <= 48) { x = x + 5; } else { x = x; }
			 */
			System.out.println("right");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {	
			
				
			manager.addObject(projectile = new Projectile(unicorn.x + 30, unicorn.y + 25, 10,10));
			
			//y = y - 10;
		}
			
			
		
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			//y = y + 10;
			scrollSpeed = 3;
			yvel =0;
			Trees.fast = false;
			manager.fast2 = false;
			
		}
		}
	

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// unicorn.update("space");
			scrollSpeed = 3;
			Trees.slow = false;
			Boost.slow = false;
			ObjectManager.slow2 = false;
			System.out.println("space");

		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			manager.setRight(0);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			
		}

	}
}
