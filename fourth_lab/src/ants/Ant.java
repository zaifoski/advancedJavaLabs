package ants;

import java.util.List;
import java.util.Random;

public class Ant {

	private Point location, nest;
	private boolean carryingFood;
	private long lifespan;
	private Environment env;
	
	public Ant(Point location, Point nest,Environment env){
		this.location=location;
		this.nest=nest;
		this.env=env;
		carryingFood=false;
		lifespan=30;		
	}
	
	public void behave(){
		if(lifespan>0){
			if(carryingFood){
				//returns a point one step closer to target point				
				location = location.stepInDirection(nest);
			} else {
				//go to a random neighbor point
				List<Point> neighbours = location.neighbours();
				Random rand = new Random();
				location = neighbours.get(rand.nextInt(neighbours.size()));
				//I get random integer from 0 to size-1
			}
			lifespan--;
			if(lifespan==0){
				;
			} else {
				if(location.equals(nest)&&carryingFood){
					;//drop food
				} else {
					;//pick food if there is and we are outside the nest
				}
			}
		}
	}
	
	public Point getLocation() {
		return location;
	}

	public boolean getCarryingFood() {
		return carryingFood;
	}
	public void setCarryingFood(boolean carryingFood) {
		this.carryingFood = carryingFood;
	}
	public long getLifespan() {
		return lifespan;
	}
	public void setLifespan(long lifespan) {
		this.lifespan = lifespan;
	}
}
