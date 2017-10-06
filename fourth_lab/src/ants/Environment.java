package ants;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Environment {

	private int height;
	private int width;
	private Map<Point,Food> foodLocations;
	
	public Environment(int height, int width){
		this.height=height;
		this.width=width;
		foodLocations = new ConcurrentHashMap<Point,Food>();
			
	}
	
	//It stores food in a thread-safe map
	
	//The update method will generate a new food and place it on the map. 
	//The location of the food should be random
	public void update(){
		Food newFood = new Food(1);
		Random xRand = new Random(); int x = xRand.nextInt();//fix
		Random yRand = new Random(); int y = yRand.nextInt();//fix
		Point newPoint = new Point(x,y);
		foodLocations.put(newPoint, newFood);
	}
	
	public Boolean hasFood(Point point){ 
		if(foodLocations.containsKey(point)) return true;
		return false;
	}
	
	public void dropFood(Point point){ 
		if(foodLocations.containsKey(point)){
			Food f = foodLocations.get(point);
			f.addFood(1);
			foodLocations.put(point,f);
		}
	}

}
