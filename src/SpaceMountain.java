import javax.swing.JFrame;

public class SpaceMountain {
	JFrame frame;
	GamePanel gamepanel;
	final static int height = 500;
	final static int width = 300;
	public static void main(String[] args) {
		SpaceMountain sp = new SpaceMountain();
		
	}
	public SpaceMountain() {
		frame = new JFrame();
		gamepanel = new GamePanel(width, height);
		setup();
		
	}
	void setup(){
		
		
		frame.add(gamepanel);
		frame.setSize(300, 500);
		frame.setVisible(true);
		
		
}
}
