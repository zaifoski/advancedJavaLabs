package ants;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AntFarm {

	//Each AntFarm has an environment, a nest location and a list of ants. 
	private Environment environment;
	private Point nestLocation;
	private List<Ant> ants;
	
	private ExecutorService executor;
	
	public AntFarm(Environment environment,Point nestLocation){
		this.environment=environment;
		this.nestLocation=nestLocation;
		ants=Arrays.asList(new Ant(nestLocation,nestLocation,this.environment),
								new Ant(nestLocation,nestLocation,this.environment),
								new Ant(nestLocation,nestLocation,this.environment));
		
		//It also has a fixed thread pool executor.
		executor = Executors.newFixedThreadPool(2);
	}
	
	//Create a run method that makes the ants move concurently
	public void run() throws InterruptedException{
		//It waits until each ant makes its step..
		//Then it calls the update function of the environment.
		//The loop starts again.
		display();
		CountDownLatch awaitAnts = new CountDownLatch(ants.size());
		for(Ant ant:ants){
			executor.execute(()->{
				ant.behave();
				awaitAnts.countDown();
			});
		}
		awaitAnts.await();
		environment.update();
	}
	
	//Create a method display in AntFarm. 
	//This goes over each location, and displays 'N' for the location of the nest, 
	//'A' for an ant, 
	//or the character that is returned by the method displayPoint of the environment.
	public void display(){
		for (int i = 0; i < environment.getWidth(); i++){
			for (int j = 0; j < environment.getHeight(); j++){
				Point currentPoint = new Point(i,j);
				Boolean foundAnt = false;
				if(currentPoint.equals(nestLocation)){
					System.out.print("N");
				} else {
					for(Ant ant:ants){
						if(currentPoint.equals(ant.getLocation())){
							System.out.print("A");
							foundAnt = true;
						}
					}
					if(!foundAnt){
						System.out.print(environment.displayPoint(currentPoint));
					}
				}
			}			
			System.out.print("\n");
		}
		System.out.print("\n\n");
	}

	public static void main(String[] args) throws InterruptedException {

		Environment environment = new Environment(60,15);
		Point nestLocation=new Point(10,10);
		AntFarm antFarm = new AntFarm(environment,nestLocation);
		for(int i = 0; i < 10; i++){
			antFarm.run();
		}

	}
}
