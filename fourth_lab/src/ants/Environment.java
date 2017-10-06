package ants;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Environment {

	private final int height;
	private final int width;
	private Map<Point,Food> foodLocations;
	private Random rand;
	
	public Environment(int height, int width){
		this.height=height;
		this.width=width;
		foodLocations = new ConcurrentHashMap<Point,Food>();
		
		rand = new Random();
			
	}
	
	//It stores food in a thread-safe map
	
	//The update method will generate a new food and place it on the map. 
	//The location of the food should be random
	public void update(){
		Food newFood = new Food(5);
		Point newPoint = new Point(rand.nextInt(width),rand.nextInt(height));
		foodLocations.put(newPoint, newFood);
	}
	
	public boolean hasFood(Point point){ 
		if(foodLocations.containsKey(point) && 
				foodLocations.get(point).getAmount()>0) return true;
		return false;
	}
	
	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public void dropFood(Point point){ 
		if(foodLocations.containsKey(point)){
			Food f = foodLocations.get(point);
			f.addFood(1);
		}
	}
	
	public String displayPoint(Point point){ 
		if(foodLocations.containsKey(point)){
			return "#";
		} return "_";
	}

}
