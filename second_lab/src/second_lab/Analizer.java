package second_lab;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Analizer {
	
	public static void analizeClass(Object o){
		
		//The dynamic type of the object
		
		Class<?> cls = o.getClass(); //question mark because we dont know which java class it will be
		
		System.out.println("The dynamic type of the object "+cls);		
		
		//Static and non-static fields separately 
		//and their values
		
		Field[] fields = cls.getDeclaredFields();
		List<Field> staticFields = new ArrayList<Field>();
		List<Field> nonStaticFields = new ArrayList<Field>();
		for(Field field:fields){
			int modifier = field.getModifiers();
			//if (modifier == 8) staticFields.add(field);
			if (java.lang.reflect.Modifier.isStatic(modifier)) staticFields.add(field);
			else nonStaticFields.add(field);
		}
		System.out.println("STATIC FIELDS: ");
		for(Field staticField:staticFields)System.out.println(staticField);
		System.out.println("NON STATIC FIELDS: ");
		for(Field nonStaticField:nonStaticFields)System.out.println(nonStaticField);
		
		//It should also print out the non-static 
		//methods of the object with their 
		//signatures (types of arguments)
		
		Method[] methods = cls.getDeclaredMethods();
		List<Method> staticMethods = new ArrayList<Method>();
		for(Method method:methods){
			int modifier = method.getModifiers();
			if (java.lang.reflect.Modifier.isStatic(modifier)){
				staticMethods.add(method);
			}
		}
		System.out.println("STATIC METHODS: ");
		for(Method staticMethod:staticMethods){
			System.out.println("STATIC METHOD: ");
			System.out.println(staticMethod);
			Class<?>[] arguments = staticMethod.getParameterTypes();
			for(Class<?> argument:arguments){
				System.out.println("ARGUMENT: ");
				System.out.println(argument);
			}

		}

	}
	
	public static void main(String args[]){
		
		String test = new String();
		analizeClass(test);
	}

}
