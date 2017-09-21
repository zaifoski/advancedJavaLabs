package university;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
	
	Set<Course> attend = new HashSet<Course>();

	public Student(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigInteger balance() {
		// TODO Auto-generated method stub
		Integer numCourses = attend.size();
		BigInteger debt = new BigInteger(String.valueOf(- numCourses * 20));
		return debt;
	}

}
