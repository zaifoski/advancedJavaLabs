package second_lab;

import java.lang.reflect.InvocationTargetException;

public class RunnerTest {	
		
		
	public static void main(String args[]) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<String> stringCls = String.class;
		
		System.out.println("Im the one arg main");
		Runner.runMain(Runner.class, new String[] {"hello","world"});
	
	}

}
