import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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
	Unicorn unicorn = new Unicorn(150, 40 ,50,50);
	ObjectManager manager;
	Rainbow rainbow;
	final int menu = 0;
	final int game = 1;
	int current_state = menu;
	// GamePanel
	public static BufferedImage unicornImg;
	public static BufferedImage treeImg;

	public GamePanel(int frameWidth, int frameHeight) {
		this.frameHeight = frameHeight;
		this.frameWidth = frameWidth;
		Timer timer = new Timer(1000 / 60, this);
		timer.addActionListener(this);

		manager = new ObjectManager();
		// manager.addObject(unicorn);

		try {

			background = ImageIO.read(getClass().getResource("image2.jpg"));
			backgroundHeight = background.getHeight();
			System.out.println(backgroundHeight);

			treeImg = ImageIO.read(this.getClass().getResourceAsStream("tree.png"));
			unicornImg = ImageIO.read(this.getClass().getResourceAsStream("rainbowdash.png"));
		} catch (Exception e) {
			System.out.println("no background image");
		}

		timer.start();
		if (timer.isRunning()) {
			System.out.println("true");
		}

	}

	void updateGameState() {
		manager.update();
		manager.manageTrees();
		manager.setScore(score++);
		manager.addObject(rainbow = new Rainbow(unicorn.x-15+x, unicorn.y-5+y, 10,10));
		
		/*
		manager.checkCollision();
		 if(unicorn.isAlive==false) {
			
			 manager.reset();
			 Unicorn unicorn = new Unicorn(150,20,50,50);
			 manager.addObject(unicorn);
			 manager.setScore(0);
		 }
		 */
	}
	
	/*void drawMenuState(Graphics g) {
		g.drawRect(0, 0, 300, 500);
		 g.setColor(Color.BLUE);
		 g.fillRect(0, 0, SpaceMountain.width, SpaceMountain.height);
		 //g.setFont(titleFont);
		 //g.setColor(Color.WHITE);
		 //g.drawString("", 100, 300);
		 
	 }
	 */

	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, frameWidth, frameHeight, 0/*+ x*/, y1, frameWidth  /*+ x*/, y2, this);
		// System.out.println("paint");
		g.drawImage(GamePanel.unicornImg, 120+x, 20+y, 50, 50, null);
		manager.draw(g);
		
		 g.setColor(Color.WHITE);
		g.drawString("SCORE: " + manager.getScore(), 200, 30);
	}
	
	/*public void paintComponent2(Graphics g) {
	
		if(current_state == menu) {
			drawMenuState(g);
		}
		else if(current_state == game) {
			paintComponent(g);
		}
	}
	*/
	
	/*void updateMenuState() {
		//manager.setScore(0);
	}*/
	
	 private int scrollSpeed = 3;
	double yvel = 0;
	double gravity = 0.01;

	public void moveBackground() {
		if (y1 >= (backgroundHeight - frameHeight)) {
			y1 = 0;
			y2 = frameHeight;
		} else {
			
			 y1+=scrollSpeed;

			y2+=scrollSpeed;			
			
			
	/*		y1 += yvel;
			y2 += yvel;
			yvel += gravity;

			
			if (yvel >= 4) {
				// sets max speed at 4
				y1 += 4;
				y2 += 4;
				yvel = 4;
				}
*/
			
			// System.out.println(yvel);
		}
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		moveBackground();
		updateGameState();
		// System.out.println("actionperformed");
		//repaint();
		
		/*if(current_state == menu) {
			updateMenuState();
		}
		else if(current_state == game) {
			updateGameState();
			moveBackground();
			System.out.println("actionperformed");
		}
		*/
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		/*if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			
			current_state++;
				if(current_state > game) {
					current_state = menu;
				}
		*/
		
		
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// Unicorn.update("space");
			scrollSpeed = 1;
			yvel = 1;
			System.out.println("space");
			Trees.slow = true;
			ObjectManager.slow2 = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
		
			x = x - 10;
			
				
			
			
			/*if (x >= 5) {
				x = x - 5;
			} else {
				x = x;
			}
			*/
			System.out.println("left");
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			x = x+10;
			
			
			
			/*if (x <= 48) {
				x = x + 5;
			} else {
				x = x;
			}*/
			System.out.println("right");
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			y = y -10;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			y = y +10;
		}
		}
	

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			// Unicorn.update("space");
			scrollSpeed = 3;
			Trees.slow = false;
			ObjectManager.slow2 = false;
			System.out.println("space");

		}
		
	}
}
