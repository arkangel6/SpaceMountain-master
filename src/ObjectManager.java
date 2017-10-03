import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	ArrayList<GameObject> objects;

	long treeTimer = 0;
	int treeSpawnTime = 1000;

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
		if (System.currentTimeMillis() - treeTimer >= treeSpawnTime) {
			addObject(new Trees(new Random().nextInt(SpaceMountain.width), 500, 50, 50));
			treeTimer = System.currentTimeMillis();
		}
	}

}
