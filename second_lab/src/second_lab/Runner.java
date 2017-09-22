package second_lab;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {
	
	/*
	 * runMain checks whether the class actually has a static method called main,
	 *  then it invokes the method main.
	 */
	static void runMain(Class<?> cls, String[] mainArgs) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<String[]> firstArgType = String[].class;
		Class<Integer> secondArgType = Integer.class;
		Method mainMethod = cls.getDeclaredMethod("main", firstArgType);
		mainMethod.invoke(null, new Object[]{mainArgs});
	}
	
	/*
	 * callToString takes an Object and invokes its toString method via reflection.
	 */
	static void callToString(Object o){
		
	}

	public static void main(String args[]) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Class<String> stringCls = String.class;
		
		System.out.println("Im the one arg main");
		for(String s:args) System.out.println(s);
	
	}

	
	public static void main(String args[], Integer n){
		
		System.out.println("Im the 2 arg main");

	}

}
