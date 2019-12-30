import java.util.Arrays;
import java.util.HashSet;

public class MemberCheck {

	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
		HashSet<String> club1set = new HashSet<String> () ; //need to make it a HashSet bc it doesn't matter if has the same person in same club multiple times
		club1set.addAll(Arrays.asList(club1)); ///add them into set.

		HashSet<String> club2set = new HashSet<String> () ;
		club2set.addAll(Arrays.asList(club2)); 

		HashSet<String> club3set = new HashSet<String> () ;
		club3set.addAll(Arrays.asList(club3)); 
		//need a copy for club that is mutated (1). 

		HashSet<String> club1setcopy = (HashSet<String>) club1set.clone(); //clone method is returning an object, HashSet is an object so java doesn't know if what returning is a HAshSet
		//above need to tell java that when you clone it's making a hashSet put it before

		//intersections
		club1set.retainAll(club2set); 
		club1setcopy.retainAll(club3set);
		club2set.retainAll(club3set);
		//have to make an array out of intersections
		int k = club1set.size() + club1setcopy.size()+ club2set.size(); //need to calculate size of array needed before creating new array below
		String[] intersections = new String[k] ; //intersections is primitive so can't call anything on it besides length
		int sum1 = 0;
		for (String fillIn : club1set) { //iterating through club1set to fill the array intersect
			intersections[sum1] = fillIn; //need to add sum1 so that intersection fills in a different index going up by one each time
			sum1 += 1;
		}
		for (String fillIn : club1setcopy) { //iterating through club1set to fill the array intersect
			intersections[sum1] = fillIn; //need to add sum1 so that intersection fills in a different index going up by one each time
			sum1 += 1;
		}
		for (String fillIn : club2set) { //iterating through club1set to fill the array intersect
			intersections[sum1] = fillIn; //need to add sum1 so that intersection fills in a different index going up by one each time
			sum1 += 1;
		}
		 Arrays.sort(intersections); //arrays.sort puts it into alphabetical order and mutates it, overwrites it so need return on next line
		 HashSet<String> returnValue = new HashSet<String>(Arrays.asList(intersections));
		 String[] lastArray = (String[]) returnValue.toArray();//return is the last thing in a method
		 Arrays.sort(lastArray); // first HashSet to eliminate the doubles, then turn it back into an array to do the sort
		 return lastArray;
	}
}	