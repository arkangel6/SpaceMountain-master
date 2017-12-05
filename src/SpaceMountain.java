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
	}

	void setup() {

		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setSize(800, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
