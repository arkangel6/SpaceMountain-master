import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {

	ArrayList<GameObject> objects;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}
	public void addObject(GameObject o) {
		objects.add(o);
		
	}
	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
	}


}
