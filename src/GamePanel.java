import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{

	private BufferedImage background;
	private int backgroundHeight = 0;
	int frameWidth;
	int frameHeight;
	int y1 =0;
	int y2 = 500;
	int x;
	
	//Unicorn unicorn = new Unicorn(150, 40 ,50,50);
	//ObjectManager manager;
	//GamePanel
	public static BufferedImage unicornImg;
	
	public GamePanel(int frameWidth, int frameHeight){
	this.frameHeight = frameHeight;
	this.frameWidth = frameWidth;
	Timer timer = new Timer(1000/60, this);
	timer.addActionListener(this);
	
	//manager = new ObjectManager();
	//manager.addObject(unicorn);
	
	try {
		
		background = ImageIO.read(getClass().getResource("image.png"));
		backgroundHeight = background.getHeight(); 
		System.out.println(backgroundHeight);
		
		unicornImg = ImageIO.read(this.getClass().getResourceAsStream("rainbowdash.png"));
		}
		catch (Exception e) {
		System.out.println("no background image");
	}
	
	timer.start();
	if(timer.isRunning()){
		System.out.println("true");
		}
		
	}
	
	
	
	
	
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, frameWidth, frameHeight, 0, y1, frameWidth, y2 , this);
		//System.out.println("paint");
		
	}
	
	
	//private int scrollSpeed = 3;
	double yvel=0;
	double gravity = 0.01;
	public void moveBackground() {
		if(y1>=(backgroundHeight-frameHeight)) {
			y1 = 0;
			y2 = frameHeight;
		} 
		else {
			y1+=yvel;
			y2+=yvel;
			yvel+=gravity;
			
			
			//y1+=scrollSpeed;
			//y2+=scrollSpeed;
			
		}
		repaint();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		moveBackground();
	//System.out.println("actionperformed");
	}





	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_SPACE) {
			Unicorn.update("space");
		
		System.out.println("space");
	}
	}





	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
	
	
	


