package ants;

public class Food {
	
	private int amount;
	
	public Food(int amount){
		this.amount = amount;
	}

	public synchronized int getAmount() {
		return amount;
	}

	public synchronized boolean removeFood(){
		if(this.amount > 0) {
			amount -= 1;
			return true;
		}
		return false;
	}

	public synchronized void addFood(int value){
		amount += value;
	}
}
