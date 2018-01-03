import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	ArrayList<GameObject> objects;

	long treeTimer = 0;
	long treeTimer2 = 0;
	long treeTimer3 = 0;
	long treeTimer4 = 0;
	
		int treeSpawnTime = 1500;
		int treeSpawnTime2 = 200;
		int treeSpawnTime3 = 200;
		int treeSpawnTime4 = 500;
		
		long boostTimer = 0;
		int boostSpawnTime = 1200;
	static boolean slow2 = false;
	 static boolean fast2 = false;
	 
	 long boostDuration = 0;
	 int boostDurationTime = 5000;
	 
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

		purgeObjects();
	}
	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void draw(Graphics g) {
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
			g.setColor(Color.yellow);
			g.drawRect((int)o.collisionBox.getX(), (int)o.collisionBox.getY(), (int)o.collisionBox.getWidth(), (int)o.collisionBox.getHeight());
		}
	}

	public void manageTrees() {
		
		if(slow2) {
			treeSpawnTime = 3000;
			treeSpawnTime2 = 600;
			treeSpawnTime3 = 600; 
			treeSpawnTime4 = 1500;
			boostSpawnTime = 3000;
		}
		
		else {
			treeSpawnTime = 1500;
			treeSpawnTime2 = 200;
			treeSpawnTime3 = 200;
			treeSpawnTime4 = 500;
			boostSpawnTime = 1200;
		}
		
		if (System.currentTimeMillis() - treeTimer >= treeSpawnTime) {
			int r = new Random().nextInt(SpaceMountain.width);
			addObject(new Trees(r, 500, 50, 50));
			

			treeTimer = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - treeTimer2 >= treeSpawnTime2) {
			int r = new Random().nextInt(50);
			int s = new Random().nextInt(40);
			addObject(new Trees(0+r, 500, 50+s, 50+s));
			

			treeTimer2 = System.currentTimeMillis();
		}
		if (System.currentTimeMillis() - treeTimer3 >= treeSpawnTime3) {
			int r = new Random().nextInt(120);
			int s = new Random().nextInt(40);
			addObject(new Trees(640+r, 500, 50+s, 50+s));
			

			treeTimer3 = System.currentTimeMillis();
		}
		/*if (System.currentTimeMillis() - treeTimer4 >= treeSpawnTime4) {
			int a = new Random().nextInt(40)+240;
			addObject(new Trees(a, 500, 50, 50));
			int b = new Random().nextInt(20);
			addObject(new Trees(b, 500, 50, 50));
			treeTimer4 = System.currentTimeMillis();
		}	*/
		
		if (System.currentTimeMillis() - boostTimer >= boostSpawnTime) {
			int r = new Random().nextInt(50);
			
			
			if(fast2){
				
			}
			else{
			addObject(new Boost(500+r, 500, 55, 60));
			boostTimer = System.currentTimeMillis();
			}
		}
	} 
		

			
		
	
	
	public void checkCollision() {
		
		
		
		
		
		if(fast2) {
		
			System.out.println("hi");
						
	
			
		}
		else {
			System.out.println("cosalasdhfjas");
			for (int i = 0; i < objects.size(); i++) {
					for (int j = i + 1; j < objects.size(); j++) {
			
		GameObject o1 = objects.get(i);
					GameObject o2 = objects.get(j);
					if(o1.collisionBox.intersects(o2.collisionBox)){
						if((o1 instanceof Unicorn && o2 instanceof Trees) ||
								(o2 instanceof Unicorn && o1 instanceof Trees)){
							o1.isAlive = false;
							o2.isAlive = false;
							System.out.println("collsiionsd ");
						}
						
						if(o1.collisionBox.intersects(o2.collisionBox)){
							if((o1 instanceof Unicorn && o2 instanceof Boost) ||
									(o2 instanceof Unicorn && o1 instanceof Boost)){
								
								if (System.currentTimeMillis() - boostDuration >= boostDurationTime) {
									
									fast2 = true;
									Trees.fast = true;

									treeTimer = System.currentTimeMillis();
								}
								
								
								
								
								/*o1.isAlive = false;
								o2.isAlive = false;
								System.out.println("collsiionsd ");*/
		}
		}
					}
					}
			}
		}
		}
		
		

	public void setScore(int s) {
		score = s;
	}

	public int getScore() {
		return score;
	}
	public void reset(){
		objects.clear();
	}
	private int left = 0;
	public void setLeft(int l) {
		left = l;
	}
	public int getLeft() {
		return left;
	}
	
	
	private int right = 0;
	public void setRight(int r) {
		right = r;
	}
	public int getRight() {
		return right;
	}
}
