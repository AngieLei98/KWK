import java.util.Arrays;
import java.util.HashSet;

public class MemberCheck { 

	public String[] whosDishonest(String[] club1, String[] club2, String[] club3) {
		HashSet<String> club1set = new HashSet<String> () ; //need to make it a HashSet bc it doesn't 
		//matter if has the same person in same club multiple times
		club1set.addAll(Arrays.asList(club1)); ///add them into set.
		HashSet<String> club2set = new HashSet<String> () ;
		club2set.addAll(Arrays.asList(club2)); 
		HashSet<String> club3set = new HashSet<String> () ;
		club3set.addAll(Arrays.asList(club3)); 
		//need a copy for club that is mutated (1). 
		HashSet<String> club1setcopy = (HashSet<String>) club1set.clone(); //clone method is returning an object, 
		//HashSet is an object so java doesn't know if what returning is a HAshSet
		//above need to tell java that when you clone it's making a hashSet put it before
		club1set.retainAll(club2set); //intersections
		club1setcopy.retainAll(club3set);
		club2set.retainAll(club3set);//is a mutating functions, instead of returning just wipes out and replaces. 
		//do set difference to eliminate the intersections between the intersections with removeall
		//OR better make a new set with all te intersections together to remove the intersections between intersections
		HashSet<String> allintersections = new HashSet<String> () ; 
		allintersections.addAll(club1set);
		allintersections.addAll(club1setcopy);
		allintersections.addAll(club2set);
		//need to return an array //create new return array
		String[] Dishonest = new String[allintersections.size()] ;
		allintersections.toArray(Dishonest); //toArray puts it into Dishonest. 
		Arrays.sort(Dishonest);//sorts alphabetically
		return Dishonest ; 
	}
}	

