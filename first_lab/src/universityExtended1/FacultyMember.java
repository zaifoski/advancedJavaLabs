package universityExtended1;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class FacultyMember extends Person implements Checkable {
	
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

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		return deliver.size() >= 4 && deliver.size() <= 8;
	}

}
