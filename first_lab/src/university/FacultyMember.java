package university;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class FacultyMember extends Person {
	
	Set<Course> deliver = new HashSet<Course>();

	public FacultyMember(String name, int id) {
		super(name, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BigInteger balance() {
		// TODO Auto-generated method stub
		Integer numCourses = deliver.size();
		BigInteger debt = new BigInteger(String.valueOf(numCourses * 30));
		return debt;
	}

}
