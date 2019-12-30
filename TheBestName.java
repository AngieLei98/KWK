import java.util.Arrays;
import java.util.Comparator;

public class TheBestName {
	public String[] sort(String[] names) {
		Arrays.sort(names, new Comparator<String>() { //java needs either a comparator or comparable to sort
			//comparator method takes two strings, whereas comparable 
			//takes only one object assuming it's defined somewhere else
			//new Comparator is an object that contains only compare method and will call that. 

			@Override
			public int compare(String A, String B) {
				if(A.equals("JOHN")) {
					return -1; 
				}
				else if(B.equals("JOHN")) {
					return 1; //if B is john you want it to go first so 
				}
				int sumA = 0;
				for(int i=0; i<A.length();i++) {
					sumA+=A.charAt(i)-64;
				}
				int sumB=0;
				for(int i=0; i<B.length();i++) {
					sumB+= B.charAt(i)-64; //they're not all relative to each other so scale down ASCII table by -64
					                       //bc A is 65 in ASCII and 1 in the table they want (i.e. A:1, B:2, C:3).
				}
				if(sumA== sumB) { //.compareTo returns -,0,+
					return A.compareTo(B); //need to tell java how to compare according lexiographically
					//default java .compareTo is just alphabetical order. 
				}
				return sumB-sumA;
			}
			//need to import Comparator util.
		}); //the Arrays.sort opens some sort of huge method that comntains compare(). Comparator object
		//given as parameter only has one method. So Arrays.sort is almost like a constructor
		return names; //sort takes input array and just modify so now when you access it, it is sorted. 
		//so Arrays.sort doesn't actually return anything. 
	}
}

/** Comparable has to have object in the class definition because it needs the 'this' object ot compare to parameter
comparator (i.e. compareTo) that can be defined anywhere because it takes both things you're comparing as parameters.
**/ 
/** CORRECTION: JAVA DOESN'T ALWAYS TAKE (-) TO BE BEFORE THE 2ND PARAMETER. If you have negative'
return value, then first parameter comes before second, postivie return valye then second comes before first
zero means equal**/