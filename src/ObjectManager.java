import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	ArrayList<GameObject> objects;

	long treeTimer = 0;
	
	
	
		int treeSpawnTime = 1500;

	static boolean slow2 = false;

	private int score = 0;

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);

	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		// purgeObjects();
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}

	public void manageTrees() {
		if(slow2) {
			treeSpawnTime = 3000;
		}
		else {
			treeSpawnTime = 1500;
		}
		
		if (System.currentTimeMillis() - treeTimer >= treeSpawnTime) {
			int r = new Random().nextInt(SpaceMountain.width);
			addObject(new Trees(r, 500, 50, 50));
			addObject(new Trees(r+50, 500, 50, 50));
			addObject(new Trees(r-50, 500, 50, 50));
			
			
			treeTimer = System.currentTimeMillis();
		}
	}

	public void setScore(int s) {
		score = s;
	}

	public int getScore() {
		return score;
	}
}
