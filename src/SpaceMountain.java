import javax.swing.JFrame;

public class SpaceMountain {
	JFrame frame;
	GamePanel gamepanel;
	final static int height = 500;
	static int width = 300;
	int x;

	public static void main(String[] args) {
		SpaceMountain sp = new SpaceMountain();

	}

	public SpaceMountain() {
		frame = new JFrame();
		gamepanel = new GamePanel(width, height);
		setup();

	}

	void setup() {

		frame.add(gamepanel);
		frame.addKeyListener(gamepanel);
		frame.setSize(300, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
