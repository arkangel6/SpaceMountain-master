import javax.swing.JFrame;

public class SpaceMountain {
	JFrame frame;
	GamePanel gamepanel;
	final static int height = 500;
	static int width = 800;
	int x;

	public static void main(String[] args) {
		SpaceMountain sp = new SpaceMountain();

	}

	public SpaceMountain() {
		frame = new JFrame();
		gamepanel = new GamePanel(width, height);
		setup();
        //http://pixelartmaker.com/art/164369d8c32ba0c.png
		//http://pixelartmaker.com/art/164369d8c32ba0c
		
		//press 1 to start
		//http://pixelartmaker.com/art/d7576a1913ef78c
		
		//http://pixelartmaker.com/art/e8a4c43be6344fd
		//http://pixelartmaker.com/art/6c4c9ee3012e3d9
		
		//gameover
		//http://pixelartmaker.com/art/f1b9dcae65880f1
		
		//play again
		//http://pixelartmaker.com/art/280d37795cf6c7a
		
		//instructions
		//http://pixelartmaker.com/art/cb5c9e98551788e
		
	}

	void setup() {

		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/*Presentation:
		Must include:
	Why you made this application
		I made this application because 
	Who is it for? Who will use it?
		
	What you learned from your usability testing
	How you adapted your project in light of user feedback
	Details of the technical implementation
		Started with a scrolling background - then played around with the speed of the scroll. Trial 
		and error to find a good speed. Added random trees - and collision. Found that the trees move along
		with the unicorn - when you press right, both the unicorn and the trees go right. Found out I
		was moving the unicorn picture, not the actual unicorn object - Created a unicorn object. Changed the
		background picture. Added trees on the sides of the screen and a boost object, where you get faster if you
		touched it. Used lots of static boolean variables to implement these functions over different classes. 
		Added hurdle objects where if the user passes one, they will get more points - created a hurdle on 
		pixel art with a super wide width which was clear. Allowed the collision check to be implemented 
	*/

}
