package universityExtended2;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class University implements Checkable {
	
	Set<Course> allCourses = new HashSet<Course>();
	
	Set<Person> allPeople = new HashSet<Person>();
	
	public BigInteger calculateBalance() {
		BigInteger totBalance=BigInteger.ZERO;
		for (Person person:allPeople){
			totBalance=totBalance.add(person.balance());
		}
		return totBalance;
	}

	@Override
	public Boolean isValid() {
		// TODO Auto-generated method stub
		for (Person person:allPeople){
			if(!person.isValid())
				return false;
		}
		return true;
	}

}
